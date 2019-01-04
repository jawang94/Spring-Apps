package com.wang.dojosurvey.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller

public class SurveyController {
    @RequestMapping(value = "/")
    public String home() {
        return "home.jsp";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String input(HttpSession session, @RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="language") String language, @RequestParam(value="comment") String comment) {
        session.setAttribute("name", name);
        session.setAttribute("location", location);
        session.setAttribute("language", language);
        session.setAttribute("comment", comment);
        return "redirect:/result";
    }

    @RequestMapping("/result")
    public String result(HttpSession session, Model model) {
        model.addAttribute("name", session.getAttribute("name"));
        model.addAttribute("location", session.getAttribute("location"));
        model.addAttribute("language", session.getAttribute("language"));
        model.addAttribute("comment", session.getAttribute("comment"));
        return "result.jsp";
    }
}
