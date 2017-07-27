package gst.mockproject.ui.controller;

import gst.mockproject.database.domain.Book;
import gst.mockproject.database.domain.BookReservation;
import gst.mockproject.service.service.BookOrderServive;
import gst.mockproject.service.service.BookService;
import gst.mockproject.service.service.BorrowBookService;
import gst.mockproject.service.service.ReturnBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dinhv on 2/14/2017.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminHomeController {
    @Autowired
    BookService bookService;
    @Autowired
    BookOrderServive bookOrderServive;
    @Autowired
    BorrowBookService borrowBookService;
    @Autowired
    ReturnBookService returnBookService;
    @RequestMapping(value = "/home")
    public String AdminHome(Model model)
    {
        long totalbook = 0;
        for(Book book : bookService.GetAll())
        {
            totalbook += book.getQuantity();
        }
        model.addAttribute("totalbook", totalbook);

        model.addAttribute("totalborrowbook", borrowBookService.count());

        model.addAttribute("totalorderbook", bookOrderServive.count());

        model.addAttribute("totalreturnbook", returnBookService.count());
        return "home/home";
    }

}