package gst.mockproject.ui.controller;

import gst.mockproject.database.domain.ReturnBook;
import gst.mockproject.service.service.Pagination;
import gst.mockproject.service.service.ReturnBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dinhv on 2/18/2017.
 */
@Controller
@RequestMapping("/admin")
public class ReturnBookController {
//   danh sách trả sách
    @Autowired
    ReturnBookService returnBookService;

    @Autowired
    Pagination pagination;
    @RequestMapping(value = "/returnbook", method = RequestMethod.GET)
    public String Book(Model model, @RequestParam(name = "pagenum", defaultValue = "1") int pagenum)
    {
        pagination.setPageSize(2);
        pagination.setTotalRecord(returnBookService.count());
        pagination.setTotalPage();
        //Page<Reader> page = userService.GetAll()
        model.addAttribute("list", returnBookService.findAll(new PageRequest(pagenum - 1, pagination.getPageSize(), Sort.Direction.ASC ,"id")));
        model.addAttribute("pagenumber", pagenum);
        model.addAttribute("totalpage",pagination.getTotalPage());
        model.addAttribute("totalrecord",pagination.getTotalRecord());
        model.addAttribute("pagination",pagination.paginate(pagenum));
        return "returnbook/returnbook";
    }
// thêm sách cần trả
    @RequestMapping(value = "/addreturnbookform", method = RequestMethod.GET)
    public String addReturnBook()
    {
        return "returnbook/addreturnbook";
    }
//  chỉnh sửa thông tin trả sách
    @RequestMapping(value = "/editreturnbookform", method = RequestMethod.GET)
    public String editReturnBook()
    {
        return "returnbook/editreturnbook";
    }
//  thay đổi sách trả
    @RequestMapping(value = "/editbooks", method = RequestMethod.GET)
    public String editBooks()
    {
        return "returnbook/editbooks";
    }

    @RequestMapping(value = "/deletereturnbook", method = RequestMethod.GET)
    public String deleteBook()
    {
        return "redirect:/admin/returnbook";
    }

    @RequestMapping(value = "/addreturnbook", method = RequestMethod.POST)
    @ResponseBody
    public String Add(@RequestParam(name = "books[]") List<String> re )
    {
        String h = "";
        for(String value : re)
            h += value + " ";
        return h;
    }
}
