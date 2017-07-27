package gst.mockproject.ui.controller;

import gst.mockproject.database.domain.Reader;
import gst.mockproject.service.service.ReaderTypeService;
import gst.mockproject.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by dinhv on 2/28/2017.
 */
@Controller
@ComponentScan(basePackages = "gst.mockproject.service")
@RequestMapping("/home")
public class ProfileController {

    @Autowired
    ReaderTypeService readerTypeService;


    @Autowired
    UserService userService;

//    thông tin người dùng
    @RequestMapping("/Profile")
    public String Profile(HttpSession session, Model model)
    {
        if(session.getAttribute("readerid") != null)
        {
            Reader reader = userService.findOne((Integer) session.getAttribute("readerid"));
            if(reader != null)
                model.addAttribute("reader", reader);
            else
                model.addAttribute("reader", null);
        }
        else
        {
            model.addAttribute("reader", null);
        }
        return "profile/profile";
    }

//    form chỉnh sửa thông tin người dùng
    @RequestMapping("/EditProfile")
    public String editProfile(HttpSession session, Model model)
    {
        if(session.getAttribute("readerid") != null)
        {
            model.addAttribute("reader", userService.findOne((Integer) session.getAttribute("readerid")));
            model.addAttribute("readertype",readerTypeService.findAll());
        }
        else
        {
            model.addAttribute("reader", null);
            model.addAttribute("readertype",null);
        }

        return "profile/editprofile";
    }

//    chỉnh sửa thông tin người dùng
    @RequestMapping(value = "/EditUserInfo", method = RequestMethod.POST)
    public String edit(
                       @RequestParam(name = "hoten", defaultValue = "") String hoten,
                       @RequestParam(name = "gioitinh", defaultValue = "") String gioitinh,
                       @RequestParam(name = "ngaysinh", defaultValue = "1111-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd") Date ngaysinh,
                       @RequestParam(name = "sodienthoai", defaultValue = "") String sodienthoai,
                       @RequestParam(name = "diachi", defaultValue = "") String diachi,
                       @RequestParam(name = "email", defaultValue = "") String email ,
                       HttpSession session) throws ParseException
    {
        if(session.getAttribute("readerid") != null)
        {
            Reader reader = userService.findOne((Integer) session.getAttribute("readerid"));
            if(reader != null)
            {
                if(!hoten.equals("") && !hoten.isEmpty() && !hoten.equals(null))
                {
                    reader.setName(hoten);
                }

                if(!gioitinh.equals("") && !gioitinh.isEmpty())
                {
                    reader.setSex(gioitinh);
                }
                if(!ngaysinh.equals(null))
                {

                    reader.setBirthDay(ngaysinh);
                }
                if(!sodienthoai.equals("") && !sodienthoai.isEmpty() && !sodienthoai.equals(null))
                {
                    reader.setPhoneNumber(sodienthoai);
                }
                if(!diachi.equals("") && !diachi.isEmpty() && !diachi.equals(null))
                {
                    reader.setAddress(diachi);
                }
                if(!email.equals("") && !email.isEmpty() && !email.equals(null))
                {
                    reader.setEmail(email);
                }
                reader.setDateModified(Calendar.getInstance().getTime());
                userService.save(reader);
            }
        }

        return "redirect:/home/Profile";
    }
}
