package gst.mockproject.ui.controller;

import gst.mockproject.database.domain.Reader;
import gst.mockproject.database.domain.ReaderType;
import gst.mockproject.service.service.TypeOfUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinhv on 2/23/2017.
 */
@Controller
@ComponentScan(basePackages = "gst.mockproject.")
@RequestMapping("/admin")
public class TypeOfReaderController {
    @Autowired
    gst.mockproject.service.service.Pagination pagination;
    @Autowired
    TypeOfUserService typeOfUserService;

    @RequestMapping(value = "/TypeOfReader")
    public String TypeOfReader(Model model, @RequestParam(name = "pagenum", defaultValue = "1") int pagenum)
    {
        pagination.setPageSize(2);
        pagination.setTotalRecord(typeOfUserService.count());
        pagination.setTotalPage();
        model.addAttribute("list", typeOfUserService.findAll(new PageRequest(pagenum - 1, pagination.getPageSize(), Sort.Direction.DESC ,"id")));
        model.addAttribute("pagenumber", pagenum);
        model.addAttribute("totalpage",pagination.getTotalPage());
        model.addAttribute("totalrecord",pagination.getTotalRecord());
        model.addAttribute("pagination",pagination.paginate(pagenum));
        return "typeofuser/TypeOfUser";
    }
    @RequestMapping(value = "/AddTypeOfReader")
    public String addTypeOfReader()
    {
        return "typeofuser/AddTypeOfUser";
    }
    @RequestMapping(value = "/EditTypeOfReader/{id}")
    public String editTypeOfReader(@PathVariable String id,Model model,Model model2)
    {
        ReaderType reader = new ReaderType();
        reader=typeOfUserService.FindByID(Integer.parseInt(id));
        model.addAttribute("item",reader);
        model2.addAttribute("id",id);
        return "typeofuser/EditTypeOfUser";
    }
    @RequestMapping(value = "/DeleteTypeOfReader/{id}")
    public String deleteTypeOfReader(@PathVariable String id)
    {
        typeOfUserService.DeleteTypeOfUser(Integer.parseInt(id));
        return "redirect:/admin/TypeOfReader";
    }


    @RequestMapping(value="/solveEditType")
    public String editType(WebRequest request)
    {
        ReaderType readerType = typeOfUserService.FindByID(Integer.parseInt(request.getParameter("id")));
        readerType.setTypeName(request.getParameter("type"));
        readerType.setReservationPeriod(Short.parseShort(request.getParameter("periodlimit")));
        readerType.setNumberOfBookAllowedToBorrow(Short.parseShort(request.getParameter("booklimit")));
         typeOfUserService.ChangeTypeOfUser(readerType);
        return "redirect:/admin/TypeOfReader";
    }

    @RequestMapping(value = "/solveAddType")
    public String addType(WebRequest request)
    {
        //ReaderType readerType = new ReaderType()
        ReaderType readerType = new ReaderType(request.getParameter("name"),Short.parseShort(request.getParameter("booklimit")),Short.parseShort(request.getParameter("periodlimit")));
        typeOfUserService.SaveTypeOfUser(readerType);
        return "redirect:/admin/TypeOfReader";
    }
    @RequestMapping(value="/SearchTypeReader")
    public String search(Model model,WebRequest request)
    {
        List<ReaderType> list =(List<ReaderType>) typeOfUserService.findAll();
        ArrayList<ReaderType> roles=new ArrayList<ReaderType>();
        String cont = request.getParameter("search");
        String by = request.getParameter("id");
        if(by.equals("id"))
        {
            for(ReaderType item:list)
            {
                if(item.getId()==Integer.parseInt(cont))
                    roles.add(item);
            }
        }
        else
        {
            for(ReaderType item:list)
            {
                if(item.getTypeName().contains(cont))
                    roles.add(item);
            }
        }
        model.addAttribute("list",roles);
        return "typeofuser/TypeOfUser";
    }
}
