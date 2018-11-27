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
public class StudentController {
    @Autowired
    private final StudentService studentService;
    private final DormitoryService dormitoryService;

    public StudentController (StudentService studentService, DormitoryService dormitoryService) {
        this.studentService = studentService;
        this.dormitoryService = dormitoryService;
    }

    @RequestMapping("/students")
    public String index(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "/views/allStudents.jsp";
    }

    @RequestMapping("/students/new")
    public String newStudent(@ModelAttribute("student") Student student) {
        return "/views/newStudent.jsp";
    }

    @RequestMapping(value="/students/new", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("student") Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/students/new";
        } else {
            studentService.createStudent(student);
            return "redirect:/students";
        }
    }

    @RequestMapping(value="/students/{id}", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("student") Student student, BindingResult result, @PathVariable(value = "id") Long id) {
        if (result.hasErrors()) {
            return "redirect:/allStudents";
        } else {
            Dormitory dorm = dormitoryService.findDorm(id);
            studentService.addDorm(student,dorm);
            return "redirect:/dorms/" + id;
        }
    }
}
