package gst.mockproject.ui.controller;

import gst.mockproject.service.service.BorrowBookService;
import gst.mockproject.service.service.Pagination;
import gst.mockproject.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dinhv on 2/18/2017.
 */
@Controller
@RequestMapping("/admin")
public class BorrowBookController {
//  trang chính liệt kê danh sách mượn sách
    @Autowired
    Pagination pagination;
    @Autowired
    BorrowBookService service;

    @RequestMapping(value = "/borrowbook", method = RequestMethod.GET)
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
        return "borrowbook/borrowbook";
    }
    @Autowired
    UserService userService;
//  thêm sách muốn mượn
    @RequestMapping(value = "/addborrowbookform", method = RequestMethod.GET)
    public String AddBorrowBookForm(Model model)
    {
        model.addAttribute("list2",userService.GetAll());
        return "borrowbook/addborrowbook";
    }
//  chỉnh sửa thông tin mượn sách
    @RequestMapping(value = "/editborrowbook", method = RequestMethod.GET)
    public String editBorrowBook()
    {
        return "borrowbook/editborrowbook";
    }
//    thay đổi sách mượn
    @RequestMapping(value = "/editborrowbooks", method = RequestMethod.GET)
    public String editBooks()
    {
        return "borrowbook/editbooks";
    }
//  xóa thông tin mượn sách
    @RequestMapping(value = "/deleteborrowbook", method = RequestMethod.GET)
    public String deleteBorrowBook()
    {
        return "redirect:/admin/borrowbook";
    }
//  đăng ki mượn sách, lưu thông tin mượn sách xuống database
    @RequestMapping(value = "/addborrowbook", method = RequestMethod.POST)
    @ResponseBody
    public String AddBorrowBook()
    {
        return "borrowbook/addborrowbook";
    }
}
