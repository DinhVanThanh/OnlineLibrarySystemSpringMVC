package gst.mockproject.ui.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import gst.mockproject.database.domain.Publisher;
import gst.mockproject.databaseaccess.DAO.PublisherDAO;
import gst.mockproject.service.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

/**
 * Created by dinhv on 2/22/2017.
 */
@Controller
@ComponentScan(basePackages = "gst.mockproject.")
@RequestMapping("/admin")
public class PublisherController {

    @Autowired
    gst.mockproject.service.service.Pagination pagination;

    @RequestMapping(value = "/Publisher", method = RequestMethod.GET)
    public String publisher(Model model, @RequestParam(name = "pagenum", defaultValue = "1") int pagenum)
    {
        pagination.setPageSize(2);
        pagination.setTotalRecord(service.count());
        pagination.setTotalPage();
        //Page<Reader> page = userService.GetAll()
        int a;
        model.addAttribute("list", service.findAll(new PageRequest(pagenum - 1, pagination.getPageSize(), Sort.Direction.ASC ,"id")));
        model.addAttribute("pagenumber", pagenum);
        model.addAttribute("totalpage",pagination.getTotalPage());
        model.addAttribute("totalrecord",pagination.getTotalRecord());
        model.addAttribute("pagination",pagination.paginate(pagenum));
        return "publisher/publisher";
    }

    @RequestMapping(value = "/AddPublisher")
    public String addPublisher()
    {
        return "publisher/addpublisher";
    }

    @RequestMapping(value = "/EditPublisher/{id}")
    public String editPublisher(@PathVariable String id,Model model)
    {
        Publisher reader = service.FindByID(Integer.parseInt(id));
        model.addAttribute("item",reader);
        return "publisher/editpublisher";
    }
    @RequestMapping(value="/solveEditPub")
    public String editType(WebRequest request)
    {
        Publisher readerType = service.FindByID(Integer.parseInt(request.getParameter("id")));
        readerType.setEmail(request.getParameter("email"));
        readerType.setPublisherName(request.getParameter("PublihserName"));
        readerType.setAddress(request.getParameter("address"));
        readerType.setPhoneNumber(request.getParameter("phonenumber"));
        service.ChangePub(readerType);
        return "redirect:/admin/Publisher";
    }

    @RequestMapping(value = "/DeletePublisher/{id}")
    public String deletePublisher(@PathVariable String id)
    {
        service.DeleteO(Integer.parseInt(id));
        return "redirect:/admin/Publisher";
    }

    @Autowired
    PublisherService service;

    @RequestMapping(value="/solveAddPublisher")
    public String add(WebRequest request)
    {
        String name=request.getParameter("name");
        String phonenumber = request.getParameter("phonenumber");
        String address = request.getParameter("address");
        String email=request.getParameter("email");
        Publisher publisher = new Publisher(name,phonenumber,address,email);
        service.savePublisher(publisher);
        return "redirect:/admin/Publisher";
    }
}
