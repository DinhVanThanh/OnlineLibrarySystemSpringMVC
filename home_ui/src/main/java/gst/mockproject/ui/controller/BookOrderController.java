package gst.mockproject.ui.controller;

import gst.mockproject.database.domain.Book;
import gst.mockproject.database.domain.BookOrder;
import gst.mockproject.database.domain.BookOrderDetail;
import gst.mockproject.database.domain.Reader;
import gst.mockproject.service.service.BookOrderServive;
import gst.mockproject.service.service.MSExcelService;
import gst.mockproject.service.service.Pagination;
import gst.mockproject.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by dinhv on 2/14/2017.
 */
@Controller
@ComponentScan(basePackages = "gst.mockproject.service")
@RequestMapping("/home")
public class BookOrderController{

    @Value(value = "classpath:downloadfile/OrderBookForm.xlsx")
    Resource filepath;

    @Autowired
    MSExcelService msExcelService;

    @Autowired
    BookOrderServive bookOrderServive;

    @Autowired
    UserService userService;

    @Autowired
    Pagination pagination;
//  form đặt mua sách
    @RequestMapping(value = "/bookorder")
    public String BookOrder(Model model)
    {
        model.addAttribute("booktitle","");
        return "bookorder/BookOrder";
    }

//    đặt mua sách
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String SaveOrderBook(@RequestParam(name = "filedinhkem")MultipartFile file, Model model,
                                @RequestParam(name = "booktitle") String title,
                                @RequestParam(name = "category") String category,
                                @RequestParam(name = "publisher") String publisher,
                                @RequestParam(name = "author") String author,
                                @RequestParam(name = "quantity") int quantity,
                                HttpSession session) throws IOException
    {
//        thêm phiếu đặt sách
        Calendar calendar = Calendar.getInstance();
        List<BookOrderDetail> books;
        if(!file.isEmpty())
        {
           books = msExcelService.ReadExcelFile(file);
        }
        else
        {
            books = new ArrayList<BookOrderDetail>();
        }
        books.add(new BookOrderDetail(title, category, publisher, author, quantity ));
        BookOrder bookOrder = new BookOrder();
        bookOrder.setBooks(books);
        bookOrder.setReader(userService.findOne((Integer) session.getAttribute("readerid")));
        bookOrder.setOrderDate(calendar.getTime());
//        thêm phiếu đặt sách cho reader
        Reader reader = userService.findOne((Integer) session.getAttribute("readerid"));
        if(reader != null)
        {
            List<BookOrder> bookOrderList = reader.getBookOrderList();
            if(bookOrderList == null)
                bookOrderList = new ArrayList<BookOrder>();
            bookOrderList.add(bookOrder);
            reader.setBookOrderList(bookOrderList);
            userService.save(reader);
        }


        return "redirect:/home/BookOrderHistory";
    }

//    tải mẫu form đặt mua sách
    @RequestMapping(value = "/download")
    @ResponseBody
    public ResponseEntity<InputStreamResource> Download(HttpServletResponse response) throws IOException
    {
        msExcelService.WriteExcelFile();
        File file = new File(filepath.getFile().getAbsolutePath());
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(resource);
    }

//    Xem lịch sử đã đặt mua sách
    @RequestMapping(value = "/BookOrderHistory")
    public String BookOrderHistory(HttpSession session,Model model, @RequestParam(name = "pagenum", defaultValue = "1") int pagenum)
    {
//  phân trang
        pagination.setPageSize(6);
        PageRequest pageRequest = new PageRequest(pagenum - 1, pagination.getPageSize(), Sort.Direction.DESC ,"id");
        Page<BookOrder> bookOrders = bookOrderServive.findByReaderId((Integer) session.getAttribute("readerid"),pageRequest);
        pagination.setTotalRecord(bookOrders.getSize());
        pagination.setTotalPage();
        model.addAttribute("totalrecord", pagination.getTotalRecord());
        model.addAttribute("pagination", pagination.paginate(pagenum));
        model.addAttribute("pagenumber", pagenum);
        model.addAttribute("totalpage", pagination.getTotalPage());
        model.addAttribute("previous","/home/BookOrderHistory?pagenum=" + (pagenum - 1));
        model.addAttribute("next","/home/BookOrderHistory?pagenum=" + (pagenum + 1));
        model.addAttribute("link", "/home/BookOrderHistory?");
//        truyền dữ liệu danh sách phiếu mượn sách đã đặt mua
        model.addAttribute("bookorders",bookOrders);
        return "bookorder/BookOrderHistory";
    }

//    chi tiết sách đã đặt mua
    @RequestMapping(value = "/bookorderdetail")
    @ResponseBody
    public List<BookOrderDetail> BookOrderDetail(HttpSession session, @RequestParam(name = "bookorderid") int bookorderid)
    {
        return userService.findOne((Integer) session.getAttribute("readerid")).getBookOrderList().get(bookorderid - 1).getBooks();
    }

//    xóa yêu cầu đặt mua sách
    @RequestMapping(value = "/removeorderbook")
    @ResponseBody
    public String RemoveBookOrder(HttpSession session,@RequestParam(name = "bookorderid") int bookorderid)
    {
        bookOrderServive.delete(bookorderid);
        return "Xóa yêu cầu đặt sách thành công";
    }
}
