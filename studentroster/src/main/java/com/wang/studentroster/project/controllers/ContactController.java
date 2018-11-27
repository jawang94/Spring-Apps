package com.wang.studentroster.project.controllers;

import com.wang.studentroster.project.models.Contact;
import com.wang.studentroster.project.models.Student;
import com.wang.studentroster.project.repositories.ContactRepository;
import com.wang.studentroster.project.services.ContactService;
import com.wang.studentroster.project.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ContactController {
    @Autowired
    private final ContactService contactService;
    private final StudentService studentService;

    public ContactController(ContactService contactService, StudentService studentService) {
        this.contactService = contactService;
        this.studentService = studentService;
    }

    @RequestMapping("/contacts/new")
    public String newContact(Model model, @ModelAttribute("contact") Contact contact) {
        List<Student> students= studentService.findAll();
        model.addAttribute("students", students);
        return "/views/newContact.jsp";
    }

    @RequestMapping(value="/contacts/new", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("contact") Contact contact, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/contacts/new";
        } else {
            contactService.createContact(contact);
            return "redirect:/students";
        }
    }
}
