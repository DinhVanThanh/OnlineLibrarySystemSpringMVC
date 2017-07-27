package gst.mockproject.ui.controller;

import gst.mockproject.database.domain.*;
import gst.mockproject.service.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinhv on 2/21/2017.
 */
@Controller
@RequestMapping("/admin")
@ComponentScan(basePackages = "gst.mockproject.databaseaccess")
public class ImportBookController {

    @Autowired
    BookService bookService;
    @Autowired
    AuthorService authorService;
    @Autowired
    PublisherService publisherService;
    @Autowired
    CategoryService categoryService;

    @Autowired
    Pagination pagination;
    private static String UPLOADED_FOLDER = "D://temp//";
    @RequestMapping(value = "/importbook", method = RequestMethod.GET)
    public String importBook(Model model, @RequestParam(name = "pagenum", defaultValue = "1") int pagenum)
    {
        pagination.setPageSize(2);
        pagination.setTotalRecord(bookService.count());
        pagination.setTotalPage();
        //Page<Reader> page = userService.GetAll()
        model.addAttribute("list", bookService.findAll(new PageRequest(pagenum - 1, pagination.getPageSize(), Sort.Direction.ASC ,"id")));
        model.addAttribute("pagenumber", pagenum);
        model.addAttribute("totalpage",pagination.getTotalPage());
        model.addAttribute("totalrecord",pagination.getTotalRecord());
        model.addAttribute("pagination",pagination.paginate(pagenum));
        return "importbook/importbook";
    }
    @RequestMapping(value = "/addbook", method = RequestMethod.GET)
    public String addBook(Model model,Model model1,Model model2,Model model3)
    {
        String s1="/Image/";
        List<Book> list = bookService.GetAll();
        for(Book b:list)
        {
            String s =b.getImage();
            b.setImage(s+s1);
        }
        List<Publisher> list1=publisherService.GetAll();
        List<Author> list2=authorService.GetAll();
        List<Category> list3=categoryService.GetAll();
        model.addAttribute("list",list);
        model1.addAttribute("list1",list1);
        model2.addAttribute("list2",list2);
        model3.addAttribute("list3",list3);
        return "importbook/addbook";
    }
    @RequestMapping(value = "/editimportbook", method = RequestMethod.GET)
    public String editImportBook()
    {
        return "importbook/editimportbook";
    }



    @RequestMapping(value="/solveAddBook",method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file,
                         WebRequest request)
    {
        if (file.isEmpty()) {

            return "redirect:/admin/addbook";
        }
        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            Book book = new Book();
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
            bookService.savePublisher(book);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/admin/importbook";
    }
}
