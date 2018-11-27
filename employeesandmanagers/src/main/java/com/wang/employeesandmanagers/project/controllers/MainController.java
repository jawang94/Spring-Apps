package com.wang.employeesandmanagers.project.controllers;

import com.wang.employeesandmanagers.project.models.Employee;
import com.wang.employeesandmanagers.project.models.Manager;
import com.wang.employeesandmanagers.project.services.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private final APIService apiService;

    public MainController(APIService apiService) {
        this.apiService = apiService;
    }

    @RequestMapping("/")
    public String main(Model model) {
        List<Employee> employees = apiService.findEmployees(Long.valueOf(1));
        Manager manager = apiService.findManager(Long.valueOf(1));
        model.addAttribute("manager",manager);
        model.addAttribute("employees", employees);
        return "/views/index.jsp";
    }
}
