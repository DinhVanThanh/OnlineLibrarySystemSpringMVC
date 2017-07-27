package gst.mockproject.ui.controller;

import gst.mockproject.database.domain.Account;
import gst.mockproject.service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by dinhv on 2/27/2017.
 */
@Controller
@ComponentScan(basePackageClasses = AccountService.class)
@RequestMapping("/home")
public class ChangePasswordController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/ChangePasswordForm")
    public String ChangePassForm(@RequestParam(name = "alert", defaultValue = "-1") int alert, Model model)
    {
        switch (alert)
        {
            case 0:
            {
                model.addAttribute("alert", "Đổi mật khẩu không thành công");
                model.addAttribute("success", 0);
                break;
            }
             case 1:
            {
                model.addAttribute("alert", "Đổi mật khẩu thành công");
                model.addAttribute("success", 1);
                break;
            }
             case 2:
            {
                model.addAttribute("alert", "Xác nhận mật khẩu sai");
                model.addAttribute("success", 0);
                break;
            }
             case 3:
            {
                model.addAttribute("alert", "Nhập mật khẩu cũ sai");
                model.addAttribute("success", 0);
                break;
            }
            default:
            {
                model.addAttribute("alert",null);
            }

        }

        return "changepassword/changepassword";
    }

    @RequestMapping(value = "/change", method = RequestMethod.POST)

    public String change(@RequestParam(name = "oldpass") String oldpass,
                         @RequestParam(name = "newpass") String newpass,
                         @RequestParam(name = "passconfirm") String passconfirm,
                         Model model,
                         HttpSession session)
    {
        Account account = accountService.findByReaderId((Integer) session.getAttribute("readerid"));
        if(account != null)
        {
            if(account.getPassword().equals(oldpass))
            {
                if( newpass.equals(passconfirm))
                {
                    account.setPassword(newpass);
                    if(accountService.save(account))
                        return "redirect:/home/ChangePasswordForm?alert=1";
                    else
                        return "redirect:/home/ChangePasswordForm?alert=0";
                }
                else
                {
                    return "redirect:/home/ChangePasswordForm?alert=2";
                }
            }
            else
            {
                return "redirect:/home/ChangePasswordForm?alert=3";
            }
        }
        else
        {
            return "redirect:/home/ChangePasswordForm?alert=4";
        }
    }
}
