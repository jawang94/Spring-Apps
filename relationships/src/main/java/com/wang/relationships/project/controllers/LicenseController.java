package com.wang.relationships.project.controllers;

import com.wang.relationships.project.models.License;
import com.wang.relationships.project.models.Person;
import com.wang.relationships.project.services.LicenseService;
import com.wang.relationships.project.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LicenseController {
    @Autowired
    private final LicenseService licenseService;
    private final PersonService personService;

    public LicenseController(LicenseService licenseService, PersonService personService) {
        this.licenseService = licenseService;
        this.personService = personService;
    }

    @RequestMapping("/licenses/new")
    public String newLicense(Model model, @ModelAttribute("license") License license) {
        List<Person> persons = personService.findAll();
        ArrayList<String> names = new ArrayList<String>();
        for (Person person: persons) {
            String name = person.getFirstName() + " " + person.getLastName();
            names.add(name);
        }
        model.addAttribute("names", names);
        model.addAttribute("persons", persons);
        return "/views/newLicense.jsp";
    }

    @RequestMapping(value="/licenses/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("license") License license, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/licenses/new";
        } else {
            licenseService.createLicense(license);
            return "redirect:/licenses/new";
        }
    }
}