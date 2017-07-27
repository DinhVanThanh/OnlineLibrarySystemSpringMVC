package gst.mockproject.ui.controller;

import gst.mockproject.database.domain.Author;
import gst.mockproject.databaseaccess.jpa.SpringDAOFactory;
import gst.mockproject.service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by dinhv on 2/27/2017.
 */
@Controller

@ComponentScan(basePackages = "gst.mockproject.service.service")
@RequestMapping("/home")
public class BookController{

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/BookDetail")
    public String Home(@RequestParam(name = "bookid") int bookid, Model model)
    {
        model.addAttribute("book",bookService.findByBookID(bookid));
        return "book/bookdetail";
    }
}
