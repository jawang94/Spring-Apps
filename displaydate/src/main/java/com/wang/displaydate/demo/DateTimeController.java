package com.wang.displaydate.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class DateTimeController {
    @RequestMapping("/")
    public String home() {
        return "home.jsp";
    }

    @RequestMapping("/date")
    public String date(Model model) {
        Date date = new Date();
        String strDateFormat = "MM/dd/yyyy";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("formattedDate", formattedDate);
        return "date.jsp";
    }

    @RequestMapping("/time")
    public String time(Model model) {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedDate = dateFormat.format(date);
        model.addAttribute("formattedDate", formattedDate);
        return "time.jsp";
    }
}

