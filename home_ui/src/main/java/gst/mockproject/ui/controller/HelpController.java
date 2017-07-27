package gst.mockproject.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dinhv on 3/9/2017.
 */
@Controller
@RequestMapping("/home")
public class HelpController {
    @RequestMapping(value = "/Help")
    public String Help()
    {
        return "help/help";
    }
}
