package gst.mockproject.ui.controller;

import gst.mockproject.database.domain.Account;
import gst.mockproject.database.domain.Book;
import gst.mockproject.service.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpSession;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinhv on 2/12/2017.
 */
@Controller
@ComponentScan(basePackages = "gst.mockproject.service")
@RequestMapping("/home")
public class HomeController {

    @Autowired
    Pagination pagination;

    @Autowired
    BookService bookService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    AccountService accountService;



    @RequestMapping(value = "/index")
    public String Home(HttpSession session,Model model, @RequestParam(name = "pagenum", defaultValue = "1") int pagenum)
    {

        pagination.setPageSize(6);
        pagination.setTotalRecord(bookService.count());
        pagination.setTotalPage();
        model.addAttribute("books", bookService.findAll(new PageRequest(pagenum - 1, pagination.getPageSize(), Sort.Direction.DESC ,"id")));
        model.addAttribute("pagenumber", pagenum);
        model.addAttribute("totalpage",pagination.getTotalPage());
        model.addAttribute("totalrecord",pagination.getTotalRecord());
        model.addAttribute("pagination",pagination.paginate(pagenum));
        return "home/index";
    }
    @RequestMapping(value = "/index/category")
    public String findBookByCategory(Model model,@RequestParam(name = "categoryid") int categoryid ,@RequestParam(name = "pagenum", defaultValue = "1") int pagenum)
    {
        pagination.setPageSize(6);
        Page<Book> books = bookService.findByCategoryId(categoryid,new PageRequest(pagenum - 1, pagination.getPageSize(), Sort.Direction.DESC ,"id"));
        pagination.setTotalRecord(books.getSize());
        pagination.setTotalPage();
        model.addAttribute("books", books);
        model.addAttribute("pagenumber", pagenum);
        model.addAttribute("totalpage", pagination.getTotalPage());
        model.addAttribute("totalrecord",pagination.getTotalRecord());
        model.addAttribute("id", categoryid);
        model.addAttribute("pagination",pagination.paginate(pagenum));
        return "book/bookbycategory";
    }
    @RequestMapping(value = "/index/publisher")
    public String findBookByPublisher(Model model,@RequestParam(name = "publisherid") int publisherid ,@RequestParam(name = "pagenum", defaultValue = "1") int pagenum)
    {
        pagination.setPageSize(6);
        Page<Book> books = bookService.findByPublisherId(publisherid,new PageRequest(pagenum - 1, pagination.getPageSize(), Sort.Direction.DESC ,"id"));
        pagination.setTotalRecord(books.getSize());
        pagination.setTotalPage();
        model.addAttribute("books", books);
        model.addAttribute("pagenumber", pagenum);
        model.addAttribute("totalpage", pagination.getTotalPage());
        model.addAttribute("totalrecord",pagination.getTotalRecord());
        model.addAttribute("id", publisherid);
        model.addAttribute("pagination",pagination.paginate(pagenum));
        return "book/bookbypublisher";
    }
}
