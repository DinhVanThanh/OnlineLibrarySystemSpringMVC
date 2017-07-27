package gst.mockproject.ui.controller;

import gst.mockproject.database.domain.Reader;
import gst.mockproject.database.domain.ReaderType;
import gst.mockproject.service.service.EmailService;
import gst.mockproject.service.service.TypeOfUserService;
import gst.mockproject.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by dinhv on 2/15/2017.
 */
@Controller
@RequestMapping(value = "/admin")
@ComponentScan(basePackages = "gst.mockproject.service.service")
public class UserController {
    @Autowired
    EmailService emailService;

    @Autowired
    gst.mockproject.service.service.Pagination pagination;

    @Autowired
    TypeOfUserService typeOfUserService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(Model model, @RequestParam(name = "pagenum", defaultValue = "1") int pagenum)
    {
        pagination.setPageSize(2);
        pagination.setTotalRecord(userService.count());
        pagination.setTotalPage();
        //Page<Reader> page = userService.GetAll()
        model.addAttribute("list", userService.findAll(new PageRequest(pagenum - 1, pagination.getPageSize(), Sort.Direction.DESC ,"id")));
        model.addAttribute("pagenumber", pagenum);
        model.addAttribute("totalpage",pagination.getTotalPage());
        model.addAttribute("totalrecord",pagination.getTotalRecord());
        model.addAttribute("pagination",pagination.paginate(pagenum));
        return "user/user";
    }

    @RequestMapping(value = "/userdetail", method = RequestMethod.GET)
    @ResponseBody
    public Reader getDetail(@RequestParam(name = "readerid") int readerid)
    {
        return userService.FindByID(readerid);
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public String addUserForm(Model model)
    {
        List<ReaderType> list= (List<ReaderType>) typeOfUserService.findAll();
        model.addAttribute("list",list);
        return "user/adduser";
    }

    @RequestMapping(value = "/edituser", method = RequestMethod.GET)
    public String editUser(@RequestParam(name = "readerid") int readerid, Model model)
    {
        model.addAttribute("readertype", typeOfUserService.findAll());
        model.addAttribute("user", userService.FindByID(readerid));
        model.addAttribute("reader", readerid);
        return "user/edituser";
    }
    @RequestMapping(value = "/saveediteduser", method = RequestMethod.GET)
    public String saveEditedUser(@RequestParam(name = "readerid", defaultValue = "0") int readerid,
                                 @RequestParam(name = "name", defaultValue = "") String name,
                                 @RequestParam(name = "phonenumber", defaultValue = "") String phone,
                                 @RequestParam(name = "address", defaultValue = "") String address,
                                 @RequestParam(name = "gender", defaultValue = "") String gender,
                                 @RequestParam(name = "birthday", defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday,
                                 @RequestParam(name = "email", defaultValue = "") String email,
                                 @RequestParam(name = "readercode", defaultValue = "") String readercode,
                                 @RequestParam(name = "readertype", defaultValue = "0") int readertype)
    {
        Reader reader = userService.FindByID(readerid);
        reader.setName(name);
        reader.setPhoneNumber(phone);
        reader.setAddress(address);
        reader.setSex(gender);
        reader.setBirthDay(birthday);
        reader.setEmail(email);
        reader.setReaderCode(readercode);
        reader.setReaderType(typeOfUserService.findOne(readertype));
        reader.setMailBox(null);
        userService.saveUser(reader);
        return "redirect:/admin/user";
    }
    @RequestMapping(value = "/deleteuser", method = RequestMethod.GET)
    @ResponseBody
    public String deleteUser(@RequestParam(name = "userid") int userid)
    {
        userService.Delete(userid);
        return "1";
    }

    @RequestMapping(value="/solveadduser",method = RequestMethod.GET)
    public String addUser(
                                 @RequestParam(name = "name", defaultValue = "") String name,
                                 @RequestParam(name = "phonenumber", defaultValue = "") String phone,
                                 @RequestParam(name = "address", defaultValue = "") String address,
                                 @RequestParam(name = "gender", defaultValue = "") String gender,
                                 @RequestParam(name = "birthday", defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday,
                                 @RequestParam(name = "email", defaultValue = "") String email,
                                 @RequestParam(name = "readercode", defaultValue = "") String readercode,
                                 @RequestParam(name = "TypeOfReader", defaultValue = "0") int readertype)
    {
        Reader reader = new Reader();
        reader.setName(name);
        reader.setPhoneNumber(phone);
        reader.setAddress(address);
        reader.setSex(gender);
        reader.setBirthDay(birthday);
        reader.setEmail(email);
        reader.setReaderCode(readercode);
        reader.setReaderType(typeOfUserService.findOne(readertype));

        userService.saveUser(reader);
        return "redirect:/admin/user";
    }


    @RequestMapping(value="/sendMail")
    public String sendMail()
    {
        List<Reader> readerList = (List<Reader>) userService.GetAll();
        Calendar calendar = Calendar.getInstance();
        for(Reader readers :readerList)
        {
                emailService.setContent("Bạn " + readers.getName() + " còn 4 ngày nữa là đến hạn trả sách ! mong bạn sắp xếp thời gian trả sách đúng hạn và ngày " + calendar.getTime().toString());
                emailService.setSender("mockgst@gmail.com");
                emailService.setReceiver(readers.getEmail());
                emailService.setSubject("Nhắc nhở trả sách");
                emailService.sendEmail();
        }
        return "redirect:/admin/user";
    }
}
