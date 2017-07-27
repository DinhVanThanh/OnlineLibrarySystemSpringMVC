package gst.mockproject.ui.controller;

import gst.mockproject.database.domain.BookOrder;
import gst.mockproject.database.domain.BookOrderDetail;
import gst.mockproject.database.domain.Receipt;
import gst.mockproject.databaseaccess.DAO.BookOrderDAO;
import gst.mockproject.service.service.BookOrderServive;
import gst.mockproject.service.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;
import java.util.List;

/**
 * Created by dinhv on 2/19/2017.
 */
@Controller
@RequestMapping("/admin")
@ComponentScan(basePackages = "gst.mockproject.service.service")
public class PurchaseBookController {
    @Autowired
    BookOrderServive bookOrderServive;
    @Autowired
    ReceiptService receiptService;

    @Autowired
    gst.mockproject.service.service.Pagination pagination;
//  danh sách đặt mua sách
    @RequestMapping(value = "/purchasebookrequest", method = RequestMethod.GET)
    public String purchaseRequest(Model model, @RequestParam(name = "pagenum", defaultValue = "1") int pagenum)
    {
        pagination.setPageSize(2);
        pagination.setTotalRecord(bookOrderServive.count());
        pagination.setTotalPage();
        model.addAttribute("list", bookOrderServive.findAll(new PageRequest(pagenum - 1, pagination.getPageSize(), Sort.Direction.DESC ,"id")));
        model.addAttribute("pagenumber", pagenum);
        model.addAttribute("totalpage",pagination.getTotalPage());
        model.addAttribute("totalrecord",pagination.getTotalRecord());
        model.addAttribute("pagination",pagination.paginate(pagenum));

        return "purchasebook/purchasebook";
    }
//    duyệt yêu cầu đặt mua sách
    @RequestMapping(value = "/approvebookorder", method = RequestMethod.GET)
    @ResponseBody
    public String approveBookOrder(@RequestParam(name = "bookorderid") int bookorderid)
    {
        receiptService.saveReceipt(new Receipt(bookOrderServive.findOne(bookorderid), Calendar.getInstance().getTime(), null));
        BookOrder bookOrder = bookOrderServive.findOne(bookorderid);
        bookOrder.setApproval(true);
        bookOrder.setDateOfApproval(Calendar.getInstance().getTime());
        if(bookOrderServive.save(bookOrder))
            return String.valueOf(bookorderid);
        else
            return String.valueOf(bookorderid);
    }
//  không duyệt yêu cầ đặt sách
    @RequestMapping(value = "/cancelbookorder", method = RequestMethod.GET)
    @ResponseBody
    public String cancelBookOrder(@RequestParam(name = "bookorderid") int bookorderid)
    {
        Receipt receipt = receiptService.findByBookOrderID(bookorderid);
        if(receipt == null)
        {
            BookOrder bookOrder = bookOrderServive.findOne(bookorderid);
            bookOrder.setApproval(false);
            bookOrder.setDateOfApproval(null);
            if(bookOrderServive.save(bookOrder))
                return String.valueOf(bookorderid);
            else
                return String.valueOf(bookorderid);
        }
        else
        {
            return String.valueOf(-1);
        }
    }
    @RequestMapping(value = "/bookorderdetail", method = RequestMethod.GET)
    @ResponseBody
    public List<BookOrderDetail> getBookOrderDetail(@RequestParam(name = "bookorderid") int bookorderid)
    {
        return bookOrderServive.findOne(bookorderid).getBooks();
    }
    @RequestMapping(value = "/deletebookorder", method = RequestMethod.GET)
    @ResponseBody
    public String deleteBookOrder(@RequestParam(name = "bookorderid") int bookorderid)
    {
        if(receiptService.findByBookOrderID(bookorderid) == null)
        {
            bookOrderServive.delete(bookorderid);
            return String.valueOf(bookorderid);
        }
        else
        {
            return String.valueOf(-1);
        }

    }
}
