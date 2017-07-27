package gst.mockproject.ui.controller;

import gst.mockproject.database.domain.Category;
import gst.mockproject.service.service.CategoryService;
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
@ComponentScan(basePackages = "gst.mockproject.")
@RequestMapping("/admin")
public class CategoryController {
    @Autowired
    gst.mockproject.service.service.Pagination pagination;
    @RequestMapping(value = "/Category")
    public String Category(Model model, @RequestParam(name = "pagenum", defaultValue = "1") int pagenum)
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
        return "category/Category";
    }

    @RequestMapping(value = "/AddCategory")
    public String addCategory()
    {
        return "category/addcategory";
    }

    @RequestMapping(value = "/EditCategory/{id}")
    public String editCategory(@PathVariable String id,Model model)
    {
        Category reader = service.FindByID(Integer.parseInt(id));
        model.addAttribute("item",reader);
        return "category/editcategory";
    }

    @RequestMapping(value = "/DeleteCategory/{id}")
    public String deleteCategory(@PathVariable String id)
    {
        service.DeleteO(Integer.parseInt(id));
        return "redirect:/admin/Category";
    }

    @Autowired
    CategoryService service;

    @RequestMapping(value = "/solveAddcate")
    public  String add(WebRequest request)
    {
        String name=request.getParameter("name");
        Category category = new Category();
        category.setCategoryName(name);
        service.saveCate(category);
        return "redirect:/admin/Category";
    }
    @RequestMapping(value = "/solveEditcate")
    public String edit(WebRequest request)
    {
        Category readerType = service.FindByID(Integer.parseInt(request.getParameter("id")));
        readerType.setCategoryName(request.getParameter("name"));
        service.ChangePub(readerType);
        return "redirect:/admin/Category";
    }
}
