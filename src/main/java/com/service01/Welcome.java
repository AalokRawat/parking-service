package com.service01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by aalokr on 12/10/17.
 */

@Controller
public class Welcome {

    @RequestMapping("/")
    public String welcome(Model model){
        model.addAttribute("form", new Form());
        return "welcome";
    }
}
