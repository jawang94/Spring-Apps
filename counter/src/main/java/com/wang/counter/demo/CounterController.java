package com.wang.counter.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@Controller
public class CounterController {
    @RequestMapping("/wang_server")
    public String home(HttpSession session) {
        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        }
        Integer count = (Integer) session.getAttribute("count");
        count++;
        session.setAttribute("count", count);
        return "home.jsp";
    }

    @RequestMapping("/wang_server/counter")
    public String counter(Model model, HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        model.addAttribute("count", count);
        return "count.jsp";
    }
}
