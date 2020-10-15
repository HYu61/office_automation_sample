package pers.hyu.oa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pers.hyu.oa.dto.ReimbursementFormInfo;
import pers.hyu.oa.entity.Employee;
import pers.hyu.oa.entity.ReimbursementForm;
import pers.hyu.oa.global.infoenum.DisplayNumEnum;
import pers.hyu.oa.global.infoenum.ExpenseEnum;
import pers.hyu.oa.service.ReimbursementFormService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller("reimbursementFormController")
@RequestMapping("/form")
public class ReimbursementFormController {
    @Resource(name = "reimbursementFormService")
    private ReimbursementFormService formService;


    // swich to the create form page
    @GetMapping("/toAdd")
    public String toCreatForm(ModelMap modelMap){
        modelMap.addAttribute("reimbursementForm", new ReimbursementForm());
        modelMap.addAttribute("expenseItemList", ExpenseEnum.getAllExpense());
        return "/WEB-INF/pages/reimbursement_form_add.jsp";
    }

    // Switch to tha add form page
    @PostMapping("/add")
    public String createForm(ReimbursementForm form, HttpSession session){
        Employee employee = (Employee) session.getAttribute("employee");
        form.setApplicantSn(employee.getSn());
        formService.create(form);
        return "redirect:displayPersonalForms";
    }

    // display the detail of the form
    @GetMapping("/showFormDetail")
    public String showDetail(int formId, ModelMap modelMap){
        modelMap.addAttribute("form",formService.getById(formId));
        return "/WEB-INF/pages/reimbursement_form_detail.jsp";
    }


    // display the applicant's all forms
    @GetMapping("/displayPersonalForms")
    public String displayPersonalForms(HttpSession session, @RequestParam(defaultValue = "1")int pageNum, ModelMap modelMap){
        Employee employee = (Employee) session.getAttribute("employee");

        // set how many forms in one page
        PageHelper.startPage(pageNum, DisplayNumEnum.FORM_PAGE.getDisplayNum());
        List<ReimbursementForm> personalFormList = formService.getByApplicant(employee.getSn());
        PageInfo<ReimbursementForm> formPageInfo = new PageInfo<ReimbursementForm>(personalFormList);
        modelMap.addAttribute("personalFormList", formPageInfo);
        return "/WEB-INF/pages/reimbursement_form_personal_list.jsp";
    }


    // display the approver's all forms needs to be handle
    @GetMapping("/displayPendingForms")
    public String displayPendingForms(HttpSession session, @RequestParam(defaultValue = "1")int pageNum, ModelMap modelMap){
        Employee employee = (Employee) session.getAttribute("employee");

        // set how many forms in one page
        PageHelper.startPage(pageNum, DisplayNumEnum.FORM_PAGE.getDisplayNum());
        List<ReimbursementForm> personalFormList = formService.getByApprover(employee.getSn());
        PageInfo<ReimbursementForm> formPageInfo = new PageInfo<ReimbursementForm>(personalFormList);
        modelMap.addAttribute("pendingFormList", formPageInfo);
        return "/WEB-INF/pages/reimbursement_form_pending_list.jsp";
    }

    @GetMapping("/remove")
    public String remove(int formId){
        formService.removeById(formId);
        return "redirect:displayPendingForms";
    }
    @GetMapping("/removeMulti")
    public String removeMulti(@RequestParam List<Integer> formIds){
        formService.removeMulti(formIds);
        return "redirect:displayPendingForms";
    }

}
