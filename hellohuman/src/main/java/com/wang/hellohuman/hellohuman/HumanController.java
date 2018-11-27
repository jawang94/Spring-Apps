package com.wang.hellohuman.hellohuman;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HumanController {
    @RequestMapping("/")
    public String home(Model model, @RequestParam(value="first_name", required=false) String first_name, @RequestParam(value="last_name", required = false) String last_name) {
        if (first_name != null && last_name != null) {
            model.addAttribute("first_name", first_name);
            model.addAttribute("last_name", last_name);
            return "index.jsp";
        }
        else {
            first_name = "Anonymous";
            last_name = "Human";
            model.addAttribute("first_name", first_name);
            model.addAttribute("last_name", last_name);
            return "index.jsp";
        }
    }
}
