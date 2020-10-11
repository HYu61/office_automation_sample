package pers.hyu.oa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pers.hyu.oa.entity.Department;
import pers.hyu.oa.global.infoenum.DisplayNumEnum;
import pers.hyu.oa.service.DepartmentService;
import pers.hyu.oa.util.Util;

import javax.annotation.Resource;
import java.util.List;

@Controller("departmentController")
@RequestMapping("/dept")
public class DepartmentController {
    @Resource(name = "departmentService")
    private DepartmentService departmentService;

    /***
     * According to the page to display the department on the page
     * @param pn
     * @param modelMap
     * @return
     */
    @GetMapping("/displayAll")
    public String display(@RequestParam(value = "pageNum", defaultValue = "1") Integer pn, ModelMap modelMap) {
        PageHelper.startPage(pn, DisplayNumEnum.DEPT_PAGE.getDisplayNum());
        List<Department> deptList = departmentService.getAll();
        PageInfo<Department> pageInfo = new PageInfo<Department>(deptList);
        modelMap.addAttribute("pageInfo", pageInfo);
        return ("/WEB-INF/pages/department_list.jsp");
    }

    // switch to the add page
    @GetMapping("/toAdd")
    public String toAdd( String errMsg, ModelMap modelMap) {
        modelMap.addAttribute("errMsg", errMsg);
        return "/WEB-INF/pages/department_add.jsp";
    }


    @PostMapping("/add")
    public String add(Department dept, ModelMap modelMap) {
        String exceptionMsg = departmentService.add(dept);

        //send error message back to the page
        if (exceptionMsg != null) {
            String errMsg = String.format("ID -- %s or Name -- %s exists already, please check it", dept.getId(), dept.getName());
           modelMap.addAttribute("errMsg", errMsg);
            return "redirect:toAdd";
        }
        return "redirect:displayAll";
    }

    //switch to the edit page
    @GetMapping("/toEdit")
    public String toEdit(int id, String errMsg, ModelMap modelMap){
        modelMap.addAttribute("dept", departmentService.getById(id));
        modelMap.addAttribute("errMsg", errMsg);
        return "/WEB-INF/pages/department_edit.jsp";
    }

    @PostMapping("/edit")
    public String edit(Department dept, ModelMap modelMap){
        String exceptionMsg = departmentService.edit(dept);

        // send back error message back to the page
        if(exceptionMsg != null){
            String errMsg = String.format("Name -- %s is DUPLICATE, please check it", dept.getName());
            modelMap.addAttribute("errMsg", errMsg);
            return "redirect:toEdit?id=" + dept.getId();
        }
        return "redirect:displayAll";
    }


    // remove one department and send back the error message if there is an error
    @GetMapping("/remove")
    public String removeOne(int id, ModelMap modelMap){
        String exceptionMsg = departmentService.removeOne(id);
        if(exceptionMsg != null){
            String errMsg = String.format("There are employees in the %s dept, can not delete it", id);
            modelMap.addAttribute("errMsg", errMsg);
            return "displayAll";
        }
        return "redirect:displayAll";
    }

    // remove multi departments and send back the error message if there is an error
    @GetMapping("/removeMulti")
    public String removeMulti(String ids, ModelMap modelMap){

        // get the list of the id that the dept need to be removed
        List<Integer> idList = Util.stringToIntArrayList(ids);
        String exceptionMsg = departmentService.removeMulti(idList);
        if(exceptionMsg != null){
            String errMsg = String.format("There are employees in the [%s] dept, can not delete it", ids);
            modelMap.addAttribute("errMsg", errMsg);
            return "displayAll";
        }
        return "redirect:displayAll";
    }

}
