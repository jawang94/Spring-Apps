package com.wang.studentroster.project.controllers;

import com.wang.studentroster.project.models.Dormitory;
import com.wang.studentroster.project.models.Student;
import com.wang.studentroster.project.services.DormitoryService;
import com.wang.studentroster.project.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DormitoryController {
    @Autowired
    private final DormitoryService dormitoryService;
    private final StudentService studentService;

    public DormitoryController(DormitoryService dormitoryService, StudentService studentService) {
        this.dormitoryService = dormitoryService;
        this.studentService = studentService;
    }

    @RequestMapping("/dorms/new")
    public String newDorm(Model model, @ModelAttribute("dorm") Dormitory dorm) {
        return "/views/newDorm.jsp";
    }

    @RequestMapping(value="/dorms/new", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("dorm") Dormitory dorm, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/dorms/new";
        } else {
            dormitoryService.createDorm(dorm);
            return "redirect:/dorms/new";
        }
    }


    @RequestMapping(value = "/dorms/{id}")
    public String show(Model model, @ModelAttribute("student") Dormitory student, @PathVariable(value = "id") Long id) {
        Dormitory dorm = dormitoryService.findDorm(id);
        List<Student> students = studentService.findByDorm(dorm);
        List<Student> studentServiceAll = studentService.findAll();
        model.addAttribute("dorm", dorm);
        model.addAttribute("students", students);
        model.addAttribute("studentServiceAll", studentServiceAll);
        return "/views/Dorm.jsp";
    }
}

