package gst.mockproject.ui.controller;

import gst.mockproject.database.domain.Author;
import gst.mockproject.service.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

/**
 * Created by dinhv on 2/22/2017.
 */
@Controller
@RequestMapping("/admin")
@ComponentScan(basePackages = "gst.mockproject.service")
public class AuthorController {
    @Autowired
    AuthorService service;

    @Autowired
    gst.mockproject.service.service.Pagination pagination;

    @RequestMapping(value = "/Author")
    public String Author(Model model, @RequestParam(name = "pagenum", defaultValue = "1") int pagenum)
    {
        pagination.setPageSize(2);
        pagination.setTotalRecord(service.count());
        pagination.setTotalPage();
        //Page<Reader> page = userService.GetAll()
        model.addAttribute("list", service.findAll(new PageRequest(pagenum - 1, pagination.getPageSize(), Sort.Direction.ASC ,"id")));
        model.addAttribute("pagenumber", pagenum);
        model.addAttribute("totalpage",pagination.getTotalPage());
        model.addAttribute("totalrecord",pagination.getTotalRecord());
        model.addAttribute("pagination",pagination.paginate(pagenum));
        return "author/author";
    }
    @RequestMapping(value = "/AddAuthor")
    public String addAuthor()
    {
        return "author/addauthor";
    }
    @RequestMapping(value = "/EditAuthor/{id}")
    public String editAuthor(@PathVariable String id, Model model)
    {
        Author reader = service.FindByID(Integer.parseInt(id));
        model.addAttribute("item",reader);

        return "author/editauthor";
    }
    @RequestMapping(value = "/DeleteAuthor/{id}")
    public String deleteAuthor(@PathVariable String id)
    {
        service.DeleteO(Integer.parseInt(id));
        return "redirect:/admin/Author";
    }


    @RequestMapping(value="/solveAddauthor")
    public String add(WebRequest request)
    {
        String name=request.getParameter("name");
        Author author = new Author(name);
        service.AddAuthor(author);
        return "redirect:/admin/Author";
    }
    @RequestMapping(value="/solveEditauthor")
    public String edit(WebRequest request)
    {
        Author readerType = service.FindByID(Integer.parseInt(request.getParameter("id")));
        readerType.setAuthorName(request.getParameter("name"));
        service.ChangePub(readerType);
        return "redirect:/admin/Author";


    }

}
