package com.wang.thecide.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class CodeController {
    @RequestMapping(value = "/")
    public String home() {
        return "home.jsp";
    }


    @RequestMapping(value="/guess", method=RequestMethod.POST)
    public String guess(@RequestParam(value="code") String code) {
        String answer = "penguin";
        if (code.equals(answer)) {
            return "redirect:/code";
        }
        return "redirect:/createError";
    }

    @RequestMapping("/createError")
    public String flashMessages(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "Wrong code!");
        return "redirect:/";
    }

    @RequestMapping(value = "/code")
    public String code() {
        return "code.jsp";
    }
}
