package com.wang.ninjagold.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@Controller
public class NinjaGoldController {
    @RequestMapping("/")
    public String home(HttpSession session, Model model) {
        if (session.getAttribute("total") != null && session.getAttribute("history") != null) {
            model.addAttribute(session.getAttribute("total"));
            model.addAttribute(session.getAttribute("history"));
        }
        return "home.jsp";
    }

    @RequestMapping(value = "/process_gold", method = RequestMethod.POST)
    public String process(HttpSession session, @RequestParam(value="building") String building) {
        if (session.getAttribute("total") == null) {
            session.setAttribute("total", 0);
        }
        if (session.getAttribute("history") == null) {
            session.setAttribute("history", "");
        }
        String history_reset = (String) session.getAttribute("history");
        if (history_reset.length() > 180) {
            history_reset = "";
            session.setAttribute("history", history_reset);
        }
        if (building.equals("farm")) {
            int x = (int)(Math.random() * ((10 - 20) + 1)) + 10;
            Integer total = (Integer) session.getAttribute("total");
            total += x;
            session.setAttribute("total", total);
            String history = (String) session.getAttribute("history");
            history += "You gained " + x + " coins!<br>";
            session.setAttribute("history", history);
            return "redirect:/";
        }
        else if (building.equals("cave")) {
            int x = (int)(Math.random() * ((10 - 5) + 1)) + 5;
            Integer total = (Integer) session.getAttribute("total");
            total += x;
            session.setAttribute("total", total);
            String history = (String) session.getAttribute("history");
            history += "You gained " + x + " coins!<br>";
            session.setAttribute("history", history);
            return "redirect:/";
        }
        else if (building.equals("house")) {
            int x = (int)(Math.random() * ((5 - 2) + 1)) + 2;
            Integer total = (Integer) session.getAttribute("total");
            total += x;
            session.setAttribute("total", total);
            String history = (String) session.getAttribute("history");
            history += "You gained " + x + " coins!<br>";
            session.setAttribute("history", history);
            return "redirect:/";
        }
        else if (building.equals("casino")) {
            int x = (int)(Math.random() * ((50 + 50) + 1)) - 50;
            Integer total = (Integer) session.getAttribute("total");
            total += x;
            session.setAttribute("total", total);
            String history = (String) session.getAttribute("history");
            if (x >= 0) {
                history += "You gained " + x + " coins!<br>";
            }
            else if (x < 0) {
                history += "You lost " + x + " coins!<br>";
            }
            session.setAttribute("history", history);
            return "redirect:/";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public String reset(HttpSession session) {
        Integer reset = (Integer) session.getAttribute("total");
        reset = 0;
        session.setAttribute("total", reset);
        return "redirect:/";
    }
}
