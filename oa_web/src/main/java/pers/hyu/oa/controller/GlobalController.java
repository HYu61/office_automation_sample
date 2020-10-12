package pers.hyu.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pers.hyu.oa.entity.Employee;
import pers.hyu.oa.service.GlobalService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller("globalController")
public class GlobalController {
    @Resource(name = "globalService")
    private GlobalService globalService;

    //Switch to login page
    @GetMapping("/toLogin")
    public String toLogin(String errMsg, ModelMap modelMap) {
        modelMap.addAttribute("errMsg", errMsg);
        return "/WEB-INF/pages/login.jsp";
    }

    // login
    @PostMapping("/login")
    public String login(String sn, String password, HttpSession session, ModelMap modelMap) {
        Employee employee = globalService.login(sn, password);
        if (employee == null) {
            String errMsg = "SN or password is incorrect!";
            modelMap.addAttribute("errMsg", errMsg);
            return "redirect:toLogin";
        }
        session.setAttribute("employee", employee);
        return "redirect:personalInfo";
    }

    //switch to personal info page
    @GetMapping("/personalInfo")
    public String displayPersonalInfo() {
        return "/WEB-INF/pages/personal_info.jsp";
    }

    //logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.setAttribute("employee", null);
        return "redirect:toLogin";
    }

    @GetMapping("/toChangePassword")
    public String toChangePassword(String errMsg, ModelMap modelMap) {
        modelMap.addAttribute("errMsg", errMsg);
        return "/WEB-INF/pages/change_password.jsp";
    }

    /**
     * reset the password
     *
     * @param session
     * @param passMap  get all the info from the form, include the old password, the new password
     *                 and the repeated new password
     * @param modelMap
     * @return if the old pass is matched and the teo new password are matched, the password is reset;
     * otherwise failed and return to change password page with the message
     */
    @PostMapping("/changePassword")
    public String changePassword(HttpSession session, @RequestParam Map passMap, ModelMap modelMap) {
        Employee employee = (Employee) session.getAttribute("employee");
        if (employee.getPassword().equals(passMap.get("oldPass"))) {
            if (passMap.get("newPass").equals(passMap.get("reNewPass"))) {
                String newPass = (String) passMap.get("newPass");
                globalService.changePassword(employee, newPass);
                return "redirect:personalInfo";
            }
        }
        String errMsg = "Original pass is incorrect or the new pass is not matched.";
        modelMap.addAttribute("errMsg", errMsg);
        return "redirect:toChangePassword";
    }
}
