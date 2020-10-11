package pers.hyu.oa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pers.hyu.oa.entity.Employee;
import pers.hyu.oa.global.infoenum.DisplayNumEnum;
import pers.hyu.oa.global.infoenum.PositionEnum;
import pers.hyu.oa.service.DepartmentService;
import pers.hyu.oa.service.EmployeeService;
import pers.hyu.oa.util.Util;

import javax.annotation.Resource;
import java.util.List;

@Controller("employeeController")
@RequestMapping("/emp")
public class EmployeeController {
    @Resource(name = "employeeService")
    private EmployeeService employeeService;

    @Resource(name = "departmentService")
    private DepartmentService departmentService;


    /***
     * According to the page to display the employee on the page
     * @param pageNum
     * @param modelMap
     * @return
     */
    @GetMapping("/displayAll")
    public String displayAll(@RequestParam(defaultValue = "1") Integer pageNum, ModelMap modelMap) {
        PageHelper.startPage(pageNum, DisplayNumEnum.EMP_PAGE.getDisplayNum());
        List<Employee> empList = employeeService.getAll();
        PageInfo<Employee> pageInfo = new PageInfo<Employee>(empList);
        modelMap.addAttribute("pageInfo", pageInfo);
        return ("/WEB-INF/pages/employee_list.jsp");
    }

    //Send some info to the add page for display
    @GetMapping("/toAdd")
    public String toAdd(String errMsg, ModelMap modelMap){
        modelMap.addAttribute("employee", new Employee());
        modelMap.addAttribute("deptList", departmentService.getAll() );

        //Get all the positions from the position enum
        modelMap.addAttribute("positionList", PositionEnum.getAllPosition());
        modelMap.addAttribute("errMsg", errMsg);
        return ("/WEB-INF/pages/employee_add.jsp");
    }

    @PostMapping("/add")
    public String add(Employee employee, ModelMap modelMap){
        String exceptionMsg = employeeService.add(employee);
        if(exceptionMsg != null){
            String errMsg = String.format("SN -- %s or SIN -- %s exists already, please check it", employee.getSn(), employee.getCaSin());
            modelMap.addAttribute("errMsg",errMsg);
            return ("redirect:toAdd");
        }
        return ("redirect:displayAll");
    }

    @GetMapping("/toEdit")
    public String toEdit(String errMsg, String sn, ModelMap modelMap){
        modelMap.addAttribute("employee", employeeService.getBySn(sn));
        modelMap.addAttribute("errMsg", errMsg);
        modelMap.addAttribute("deptList", departmentService.getAll());

        //Get all the positions from the position enum
        modelMap.addAttribute("positionList", PositionEnum.getAllPosition());
        return "/WEB-INF/pages/employee_edit.jsp";
    }

    @PostMapping("edit")
    public String edit(Employee employee, ModelMap modelMap){
        String exceptionMsg = employeeService.edit(employee);
        if(exceptionMsg != null){
            String errMsg = String.format("SIN -- %s is DUPLICATE, please check it", employee.getCaSin());
            modelMap.addAttribute("errMsg", errMsg);
            return "redirect:toEdit?sn=" + employee.getSn();
        }
        return "redirect:displayAll";
    }

    @GetMapping("/remove")
    public String remove(String sn, ModelMap modelMap){
        String exceptionMsg = employeeService.removeOne(sn);
        if(exceptionMsg != null){
            String errMsg = String.format("%s has Reimbursement Forms, can not delete it", sn);
            modelMap.addAttribute("errMsg", errMsg);
            return "displayAll";
        }
        return "redirect:displayAll";
    }

    @GetMapping("/removeMulti")
    public String removeMulti(String sns, ModelMap modelMap){

        // get the list of the sn that the employee need to be removed
        List<String> snList = Util.stringToList(sns);
        String exceptionMsg = employeeService.removeMulti(snList);
        if(exceptionMsg != null){
            String errMsg = String.format("There are Reimbursement Forms belong to the [%s] employee, can not delete it", sns);
            modelMap.addAttribute("errMsg", errMsg);
            return "displayAll";
        }
        return "redirect:displayAll";
    }
}
