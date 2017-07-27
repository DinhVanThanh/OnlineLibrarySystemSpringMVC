package gst.mockproject.ui.controller;

import gst.mockproject.database.domain.Book;
import gst.mockproject.service.service.BookService;
import gst.mockproject.service.service.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by dinhv on 2/14/2017.
 */
@Controller
@ComponentScan(basePackages = "gst.mockproject.service.service")
@RequestMapping("/home")
public class SearchController {

    @Autowired
    BookService bookService;

    @Autowired
    Pagination pagination;

    @RequestMapping(value = "/simplesearchbook", method = RequestMethod.GET)
    public String SimpleSearchBook()
    {
        return "search/SimpleSearch";
    }

    @RequestMapping(value = "/simplesearch", method = RequestMethod.GET)
    public String SimpleSearch(@RequestParam(name = "search") String search, @RequestParam(name = "type") String type, Model model, @RequestParam(name = "pagenum", defaultValue = "1") int pagenum)
    {
        pagination.setPageSize(6);
        PageRequest pageRequest = new PageRequest(pagenum - 1, pagination.getPageSize(), Sort.Direction.DESC ,"id");
        Page<Book> books = bookService.SimpleSearch(search, type, pageRequest);
        pagination.setTotalRecord(bookService.countBy(type,search).longValue());
        pagination.setTotalPage();
        model.addAttribute("books",books);
        model.addAttribute("totalrecord", pagination.getTotalRecord());
        model.addAttribute("pagination", pagination.paginate(pagenum));
        model.addAttribute("pagenumber", pagenum);
        model.addAttribute("totalpage", pagination.getTotalPage());
        model.addAttribute("previous","/home/simplesearch?pagenum=" + (pagenum - 1) + "&search=" + search + "&type=" + type);
        model.addAttribute("next","/home/simplesearch?pagenum=" + (pagenum + 1) + "&search=" + search + "&type=" + type);
        model.addAttribute("link", "/home/simplesearch?search=" + search + "&type=" + type);
        if(books == null)
            model.addAttribute("nobook", 1);
        else
            model.addAttribute("nobook", 0);
        return "book/booksearch";
    }

    @RequestMapping(value = "/advancedsearchbook", method = RequestMethod.GET)
    public String AdvancedSearchBook()
    {
        return "search/AdvancedSearch";
    }

    @RequestMapping(value = "/advancedsearch", method = RequestMethod.GET)
    public String AdvancedSearch(@RequestParam(name = "booktitle", defaultValue = "null") String booktitle ,
                       @RequestParam(name = "category" ,defaultValue = "null") String category,
                       @RequestParam(name = "author", defaultValue = "null") String author,
                       @RequestParam(name = "publisher", defaultValue = "null") String publisher ,
                       Model model,
                     @RequestParam(name = "pagenum", defaultValue = "1") int pagenum)
    {

        pagination.setPageSize(6);
        PageRequest pageRequest = new PageRequest(pagenum - 1, pagination.getPageSize(), Sort.Direction.DESC ,"id");

        Page<Book> books = bookService.findByTitleOrCategoryOrAuthorOrPublisher(booktitle,category,publisher,author,pageRequest);

        pagination.setTotalRecord(bookService.countByAll(booktitle,category,publisher,author));
        pagination.setTotalPage();
        model.addAttribute("books", books);
        model.addAttribute("totalrecord", pagination.getTotalRecord());
        model.addAttribute("pagenumber", pagenum);
        model.addAttribute("totalpage", pagination.getTotalPage());
        model.addAttribute("pagination", pagination.paginate(pagenum));
        model.addAttribute("previous","/home/advancedsearch?pagenum=" + (pagenum - 1) + "&booktitle=" + booktitle + "&category=" + category + "&author=" + author + "&publisher=" + publisher);
        model.addAttribute("next","/home/advancedsearch?pagenum=" + (pagenum + 1) + "&booktitle=" + booktitle + "&category=" + category + "&author=" + author + "&publisher=" + publisher);
        model.addAttribute("link", "/home/advancedsearch?booktitle=" + booktitle + "&category=" + category + "&author=" + author + "&publisher=" + publisher );
        return "book/booksearch";
    }
}
