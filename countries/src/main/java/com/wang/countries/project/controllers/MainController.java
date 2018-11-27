package com.wang.countries.project.controllers;

import com.wang.countries.project.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private final ApiService apiService;

    public MainController(ApiService apiService) {
        this.apiService = apiService;
    }

    @RequestMapping("/")
    public String main(Model model) {
        List<Object[]> table = apiService.findCountriesSpeakingSlovene();
        model.addAttribute("table", table);
        return "/views/index.jsp";
    }
}
