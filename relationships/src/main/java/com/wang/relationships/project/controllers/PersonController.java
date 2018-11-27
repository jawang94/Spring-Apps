package com.wang.relationships.project.controllers;

import com.wang.relationships.project.models.Person;
import com.wang.relationships.project.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PersonController {
    @Autowired
    private final PersonService personService;

    public PersonController (PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/persons/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "/views/newPerson.jsp";
    }

    @RequestMapping(value="/persons/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/persons/new";
        } else {
            personService.createPerson(person);
            return "redirect:/persons/new";
        }
    }
}
