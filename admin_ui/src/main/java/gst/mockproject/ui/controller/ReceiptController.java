package gst.mockproject.ui.controller;

import gst.mockproject.database.domain.BookOrder;
import gst.mockproject.database.domain.BookOrderDetail;
import gst.mockproject.database.domain.Receipt;
import gst.mockproject.service.service.BookOrderServive;
import gst.mockproject.service.service.BorrowBookService;
import gst.mockproject.service.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by dinhv on 2/25/2017.
 */
@Controller
@RequestMapping("/admin")
public class ReceiptController {
    @Autowired
    BookOrderServive bookOrderServive;
    @Autowired
    ReceiptService receiptService;
    @Autowired
    gst.mockproject.service.service.Pagination pagination;
    @RequestMapping(value = "/Receipt")
    public String Receipt(Model model, @RequestParam(name = "pagenum", defaultValue = "1") int pagenum)
    {
        pagination.setPageSize(2);
        pagination.setTotalRecord(receiptService.count());
        pagination.setTotalPage();
        model.addAttribute("receipts", receiptService.findAll(new PageRequest(pagenum - 1, pagination.getPageSize(), Sort.Direction.DESC ,"id")));
        model.addAttribute("pagenumber", pagenum);
        model.addAttribute("totalpage",pagination.getTotalPage());
        model.addAttribute("totalrecord",pagination.getTotalRecord());
        model.addAttribute("pagination",pagination.paginate(pagenum));
        return "receipt/receipt";
    }
    @RequestMapping(value = "/EditReceiptFrom")
    public String editReceipt(Model model, @RequestParam(name = "receiptid") int receiptid)
    {
        List<Receipt> receiptList  = receiptService.findAll();
        List<BookOrder> bookOrderList = (List<BookOrder>) bookOrderServive.findAll();
        ArrayList<Integer> borrowbooklist = new ArrayList<Integer>();
        for(BookOrder item2 : bookOrderList)
        {
            boolean flag = true;
            for(Receipt  item : receiptList)
            {
                if (item.getBookOrder().getId() == item2.getId())
                {
                    flag = false;
                }
            }
            if(flag)
            {
                borrowbooklist.add(item2.getId());
            }
        }
        model.addAttribute("list", borrowbooklist);
        model.addAttribute("receiptid", receiptid);
        return "receipt/editreceipt";
    }

    @RequestMapping(value = "/EditReceipt", method = RequestMethod.GET)
    public String editReceiptDB(Model model, @RequestParam(name = "receiptid") int receiptid, @RequestParam(name = "OrderCode") int OrderCode)
    {
        Receipt receipt = receiptService.findOne(receiptid);
        receipt.setBookOrder(bookOrderServive.findOne(OrderCode));
        receiptService.saveReceipt(receipt);
        return "redirect:/admin/Receipt";
    }

    @RequestMapping(value = "/AddReceiptForm")
    public String addReceipt(Model model)
    {
        model.addAttribute("orderbook", bookOrderServive.findAll());
        return "receipt/addreceipt";
    }
    @RequestMapping(value = "/DeleteReceipt", method = RequestMethod.GET)
    @ResponseBody
    public String deleteReceipt(@RequestParam(name = "receiptid") int receiptid)
    {
        receiptService.deleteById(receiptid);
        return String.valueOf(receiptid);
    }

    @RequestMapping(value="/AddReceipt", method = RequestMethod.GET)
    public String addReceiptToDB(@RequestParam(name = "OrderCode") int OrderCode)
    {
        Receipt receipt = new Receipt();
        receipt.setBookOrder(bookOrderServive.findOne(OrderCode));
        receipt.setCreateDate(Calendar.getInstance().getTime());
        receipt.setDateModified(null);
        receipt.setLibrarian(null);
        receipt.setStatus("mới tạo");
        receiptService.saveReceipt(receipt);
        return  "redirect:/admin/Receipt";
    }
    @RequestMapping(value = "/ReceiptDetail", method = RequestMethod.GET)
    @ResponseBody
    public List<BookOrderDetail> getReceiptDetail(@RequestParam(name = "receiptid") int receiptid)
    {
        return receiptService.findOne(receiptid).getBookOrder().getBooks();
    }
    @RequestMapping(value = "/SearchReceipt", method = RequestMethod.GET)
    public String searchReceipt(Model model, @RequestParam(name = "pagenum", defaultValue = "1") int pagenum,@RequestParam(name = "search") String search)
    {
        pagination.setPageSize(2);
        pagination.setTotalRecord(1);
        pagination.setTotalPage();
        model.addAttribute("receipts", receiptService.findByBookOrderID(Integer.parseInt(search)));
        model.addAttribute("pagenumber", pagenum);
        model.addAttribute("totalpage",pagination.getTotalPage());
        model.addAttribute("totalrecord",pagination.getTotalRecord());
        model.addAttribute("pagination",pagination.paginate(pagenum));
        return "receipt/receipt";
    }

}
