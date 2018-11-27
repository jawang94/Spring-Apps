package com.wang.relationships.project.controllers;

import com.wang.relationships.project.models.License;
import com.wang.relationships.project.models.Person;
import com.wang.relationships.project.services.LicenseService;
import com.wang.relationships.project.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RelationshipController {
    @Autowired
    private final PersonService personService;
    private final LicenseService licenseService;

    public RelationshipController (PersonService personService, LicenseService licenseService) {
        this.personService = personService;
        this.licenseService = licenseService;
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String show(Model model, @PathVariable(value = "id") Long id) {
        Person person = personService.findPerson(id);
        License license = licenseService.findLicense(id);
        model.addAttribute("person", person);
        model.addAttribute("license", license);
        return "/views/person.jsp";
    }
}
