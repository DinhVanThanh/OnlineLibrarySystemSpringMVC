package gst.mockproject.ui.controller;

import gst.mockproject.database.domain.Account;
import gst.mockproject.database.domain.Reader;
import gst.mockproject.service.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by dinhv on 2/12/2017.
 */
@Controller
@ComponentScan(basePackages = "gst.mockproject.service.service")
//@RequestMapping("/admin")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    EmailService emailService;

    @Autowired
    AccountService accountService;

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/logon")
    public String authenticate(@RequestParam(name = "alert", defaultValue = "") String alert, Model model)
    {
        if(alert.equals("1"))
        {
            model.addAttribute("loginfail", "mật khẩu hoặc tài khoản đăng nhập sai");
        }
        else
        {
            model.addAttribute("loginfail", null);
        }
        return "login/login";
    }

    @RequestMapping(value = "/login")
    public String login(@RequestParam(name = "alert", defaultValue = "0") int alert, Model model, HttpSession session)
    {
        if(alert == 1)
        {
            model.addAttribute("logout","bạn đã đăng xuất thành công");
            session.removeAttribute("readerid");
        }
        else
        {
            model.addAttribute("logout",null);
        }
        return "login/login";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public String authenticate(HttpSession session, Model model)
    {
        CustomUserDetail user = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        session.setAttribute("readerid", user.getReaderid());
        session.setAttribute("adminname", userService.findOne(user.getReaderid()).getName());


        return "redirect:/admin/home";
    }

    @RequestMapping(value = "/logout")
            public String logout()
    {
        return "redirect:/login?alert=1";
    }


    @RequestMapping(value = "/loginfail")
    public String loginFail()
    {
        return "redirect:/logon?alert=1";
    }

    @RequestMapping(value = "/recoverypassword")
    @ResponseBody
    public String sendRecoceryEmail(@RequestParam(name = "email") String email)
    {
        Reader reader = userService.findByEmail(email);
        Account account = accountService.findByReaderId(reader.getId());
        if(reader != null && account != null)
        {
            emailService.setSender("mockgst@gmail.com");
            emailService.setReceiver(email);
            emailService.setSubject("khôi phục mật khẩu");
            emailService.setContent("mật khẩu của bạn " + reader.getName() + " là : " + account.getPassword());
            emailService.sendEmail();
            return "Please ,check your email to get password";
        }
        else
        {
            return "Your email is wrong or not exits";
        }
    }
}
