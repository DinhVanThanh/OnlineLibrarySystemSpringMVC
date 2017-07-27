package gst.mockproject.ui.controller;

import gst.mockproject.database.domain.Author;
import gst.mockproject.database.domain.Book;
import gst.mockproject.database.domain.Category;
import gst.mockproject.database.domain.Publisher;
import gst.mockproject.service.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinhv on 2/18/2017.
 */
@Controller
@RequestMapping("/admin")
public class BookController {
    private static String UPLOADED_FOLDER = "D://temp//";
    @Autowired
    Pagination pagination;
    @Autowired
    BookService service;
    @Autowired
    AuthorService authorService;
    @Autowired
    PublisherService publisherService;
    @Autowired
    CategoryService categoryService;
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String Book(Model model, @RequestParam(name = "pagenum", defaultValue = "1") int pagenum)
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
        return "book/book";
    }
    @RequestMapping(value = "/bookdetail", method = RequestMethod.GET)
    @ResponseBody
    public Book getDetail(@RequestParam(name = "bookid") int bookid)
    {

        return service.FindByID(bookid);
    }

    @RequestMapping(value = "/editbook/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable String id, Model model,Model model1,Model model2,Model model3)
    {
        Book book = service.FindByID(Integer.parseInt(id));
        List<Publisher> list1=publisherService.GetAll();
        List<Author> list2=authorService.GetAll();
        List<Category> list3=categoryService.GetAll();
        model1.addAttribute("list1",list1);
        model2.addAttribute("list2",list2);
        model3.addAttribute("list3",list3);
        model.addAttribute("item",book);

        return "book/editbook";
    }
    @RequestMapping(value = "/solveeditbook", method = RequestMethod.POST)
    public String solveeditBook(@RequestParam("file") MultipartFile file,
                                WebRequest request)
    {
        if (file.isEmpty()) {

            return "redirect:/admin/editbook";
        }
        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            int b;
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            Book book = service.FindByID(Integer.parseInt(request.getParameter("bookid")));
            book.setPublisher(publisherService.FindByID(Integer.parseInt(request.getParameter("publisher"))));
            List<Author> list= new ArrayList<Author>();
            list.add(authorService.FindByID(Integer.parseInt(request.getParameter("author"))));
            book.setAuthor(list);
            book.setCategory(categoryService.FindByID(Integer.parseInt(request.getParameter("cate"))));
            book.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            book.setPrice((Integer.parseInt(request.getParameter("price"))));
            book.setEdition((Integer.parseInt(request.getParameter("edition"))));
            book.setImage(path.toString());
            book.setTitle(request.getParameter("title"));
            service.savePublisher(book);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/admin/book";
    }


    @RequestMapping(value = "/deletebook", method = RequestMethod.GET)
    public String deleteBook()
    {
        return "redirect:/admin/book";
    }

}
