package gst.mockproject.ui.controller;

import gst.mockproject.database.domain.*;
import gst.mockproject.service.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by dinhv on 2/27/2017.
 */
@Controller
@RequestMapping(value = "/home")
public class BookReservationController {

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Autowired
    Pagination pagination;

    @Autowired
    BookReservationService bookReservationService;

    @Autowired
    ReaderTypeService readerTypeService;

//    giỏ hàng mượn sách
    @RequestMapping(value = "/BookReservation")
    public String Reservation(HttpSession session,Model model)
    {
        if(session.getAttribute("books") != null)
        {
            ReaderType readertype = userService.findOne((int) session.getAttribute("readerid")).getReaderType();
            List<Book> books = (List<Book>) session.getAttribute("books");
            model.addAttribute("books",books);
            Calendar calendar = Calendar.getInstance();
            Date ReservedDate = calendar.getTime();
            calendar.setTime(calendar.getTime());
            calendar.add(Calendar.DATE, readertype.getReservationPeriod());
            Date ReturnDate = calendar.getTime();
            model.addAttribute("ReservationDate", ReservedDate);
            model.addAttribute("ReturnDate", ReturnDate);
        }
        else
        {
            model.addAttribute("books",null);
        }
        return "bookreservation/bookreservation";
    }

//  mượn sách
    @RequestMapping(value = "/Reserve")
    @ResponseBody
    public String Reserve(HttpSession session, @RequestParam(name = "bookid") int bookid)
    {
//      lấy danh sách sách lưu trữ trong session giỏ hàng mượn sách
        List<Book> books ;
        if(session.getAttribute("books") != null)
        {
            books = (List<Book>) session.getAttribute("books");
        }
        else
        {
            books = new ArrayList<Book>();
        }
//        lấy sách trong database
        Book book = bookService.findByBookID(bookid);
//        thêm sách và lưu vào giỏ hàng mượn sách
        if(book != null && book.getQuantity() > 0)
        {

            int remainquantity = book.getQuantity();
            ReaderType readertype = userService.findOne((int) session.getAttribute("readerid")).getReaderType();
            if(books.size() < readertype.getNumberOfBookAllowedToBorrow() )
            {
                books.add(book);
                session.setAttribute("books", books);

                return "bạn đã đăng kí mượn sách : " + book.getTitle() + " thành công!";
            }
            else
                {
                return "Số sách bạn mượn vượt quá số lượng cho phép";
            }
        }
        else
        {
            return "Sách bạn mượn đã hết";
        }
    }

//    xóa sách muốn mượn
    @RequestMapping(value = "/RemoveReservedBook")
    @ResponseBody
    public String removeReservedBook(@RequestParam(name = "bookid") int bookid, HttpSession session, Model model)
    {
        Book book = bookService.findByBookID(bookid);
        if(session.getAttribute("books") != null && book != null)
        {
            List<Book> books = (List<Book>) session.getAttribute("books");
            for(Book item : books)
            {
                if(item.getId() == book.getId())
                {
                    books.remove(item);
                }
            }
            session.setAttribute("books", books);
        }
        else
        {
            model.addAttribute("books", null);
        }
        return book.getTitle();
    }

//    lịch sử mượn sách
    @RequestMapping(value = "/BookReservationHistory")
    public String BookReservationHistory(HttpSession session, Model model, @RequestParam(name = "pagenum", defaultValue = "1") int pagenum)
    {
//        phân trang
        pagination.setPageSize(6);
        PageRequest pageRequest = new PageRequest(pagenum - 1, pagination.getPageSize(), Sort.Direction.DESC ,"id");
        Page<BookReservation> bookReservations = bookReservationService.findByReaderId((Integer) session.getAttribute("readerid"), pageRequest);
        pagination.setTotalRecord(bookReservations.getSize());
        pagination.setTotalPage();
        model.addAttribute("totalrecord", pagination.getTotalRecord());
        model.addAttribute("pagination", pagination.paginate(pagenum));
        model.addAttribute("pagenumber", pagenum);
        model.addAttribute("totalpage", pagination.getTotalPage());
        model.addAttribute("previous","/BookReservation/History?pagenum=" + (pagenum - 1));
        model.addAttribute("next","/BookReservation/History?pagenum=" + (pagenum + 1));
        model.addAttribute("link", "/BookReservation/BookReservationHistory?");

//      truyền dữ liệu danh sách sách mượn cho view
        model.addAttribute("bookreservations",bookReservations);

        return "bookreservation/BookReservationHistory";
    }

//    xem chi tiết phiêu mượn sách
    @RequestMapping(value = "/BookReservationDetail")
    @ResponseBody
    public List<Book> BookOrderDetail(HttpSession session, @RequestParam(name = "bookreservationid") int bookreservationid)
    {
        return userService.findOne((Integer) session.getAttribute("readerid")).getBookReservationList().get(bookreservationid - 1).getBooks();
    }

//    hủy yêu cầu mượn sách
    @RequestMapping(value = "/BookReservationRemove")
    @ResponseBody
    public String RemoveBookOrder(@RequestParam(name = "bookreservationid") int bookreservationid)
    {
        bookReservationService.deleteById(bookreservationid);

        return "Xóa yêu cầu mượn sách thành công";
    }

//  lưu phiếu mượn sách
    @RequestMapping(value = "/SaveBookReservation")
    public String saveReservation(HttpSession session)
    {
        if(session.getAttribute("books") != null)
        {
            int periodlimit = 0;//số ngày tối đa mượn sách
            Date ReservedDate = null;
            Date ReturnDate = null;
//            lấy thông tin số ngày mượn sách tối đa
            if(session.getAttribute("readerid") != null)
            {
                ReaderType readertype = userService.findOne((int) session.getAttribute("readerid")).getReaderType();
//                ReaderType type = readerTypeService.findOne(readertype.getId());
                //          đặt ngày mượn ,ngày hết hạn trả sách
                Calendar calendar = Calendar.getInstance();
                ReservedDate = calendar.getTime();
                calendar.setTime(calendar.getTime());
                calendar.add(Calendar.DATE, readertype.getReservationPeriod());
                ReturnDate = calendar.getTime();
            } 

//            lưu phiếu mượn sách
            BookReservation bookReservation = new BookReservation(userService.findOne((Integer) session.getAttribute("readerid")), (List<Book>) session.getAttribute("books"), ReservedDate, ReturnDate, null, false );
            Reader reader = userService.findOne((Integer) session.getAttribute("readerid"));
            if(reader != null)
            {

                List<BookReservation> bookReservationList = reader.getBookReservationList();
                if(bookReservationList == null)
                    bookReservationList = new ArrayList<>();
                bookReservationList.add(bookReservation);
                reader.setBookReservationList(bookReservationList);
                userService.save(reader);
                List<Book> books = (List<Book>) session.getAttribute("books");
                for (Book item : books)
                {
                    if (item.getQuantity() > 0)
                    {
                        item.setQuantity(item.getQuantity() - 1);
                        bookService.save(item);
                    }
                }
//            xóa phiếu mượn sách trong session khi lưu thành công
                session.removeAttribute("books");
            }
        }

        return "redirect:/home/BookReservationHistory";
    }

    @RequestMapping(value = "/searchBookReservation", method = RequestMethod.GET)
    public String searchBookReservationHistory(@RequestParam(name = "mamuonsach" ,defaultValue = "-1") int mamuonsach,
                                               @RequestParam(name = "ngaymuonbatdau" , defaultValue = "1111-11-11") @DateTimeFormat(pattern = "yyyy-MM-dd") Date ngaymuonbd,
                                               @RequestParam(name = "ngaymuonketthuc" , defaultValue = "1111-11-11") @DateTimeFormat(pattern = "yyyy-MM-dd") Date ngaymuonkt,
                                               @RequestParam(name = "ngaytrabatdau" , defaultValue = "1111-11-11") @DateTimeFormat(pattern = "yyyy-MM-dd") Date ngaytrabd,
                                               @RequestParam(name = "ngaytraketthuc" , defaultValue = "1111-11-11")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date ngaytrakt,
                                               @RequestParam(name = "tinhtrang" ,defaultValue = "0") int tinhtrang,
                                               HttpSession session, Model model,
                                               @RequestParam(name = "pagenum", defaultValue = "1") int pagenum)
    {

        //        phân trang
        pagination.setPageSize(6);
        PageRequest pageRequest = new PageRequest(pagenum - 1, pagination.getPageSize(), Sort.Direction.DESC ,"id");
        Page<BookReservation> bookReservations = bookReservationService.findByReaderIdOrIdOrBorrowdateContainingOrReturndateContainingOrStatusAllIgnoreCase((Integer) session.getAttribute("readerid"), mamuonsach, ngaymuonbd, ngaytrabd, (tinhtrang==1?true:false), pageRequest);
        pagination.setTotalRecord(bookReservations.getSize());
        pagination.setTotalPage();
        model.addAttribute("totalrecord", pagination.getTotalRecord());
        model.addAttribute("pagination", pagination.paginate(pagenum));
        model.addAttribute("pagenumber", pagenum);
        model.addAttribute("totalpage", pagination.getTotalPage());
        model.addAttribute("previous","/home/BookReservationHistory?pagenum=" + (pagenum - 1));
        model.addAttribute("next","/home/BookReservationHistory?pagenum=" + (pagenum + 1));
        model.addAttribute("link", "/home/BookReservationHistory?");

//      truyền dữ liệu danh sách sách mượn cho view
        model.addAttribute("bookreservations",bookReservations);

        return "bookreservation/BookReservationHistory";
    }

}
