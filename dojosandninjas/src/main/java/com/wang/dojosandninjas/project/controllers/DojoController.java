package com.wang.dojosandninjas.project.controllers;

import com.wang.dojosandninjas.project.models.Dojo;
import com.wang.dojosandninjas.project.models.Ninja;
import com.wang.dojosandninjas.project.services.DojoService;
import com.wang.dojosandninjas.project.services.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DojoController {
    @Autowired
    private final DojoService dojoService;
    private final NinjaService ninjaService;

    public DojoController(DojoService dojoService, NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }

    @RequestMapping("/dojos/new")
    public String newLicense(Model model, @ModelAttribute("dojo") Dojo dojo) {
        return "/views/newDojo.jsp";
    }

    @RequestMapping(value="/dojos/new", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/dojos/new";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/dojos/new";
        }
    }

    @RequestMapping(value = "/dojos/{id}", method = RequestMethod.GET)
    public String show(Model model, @PathVariable(value = "id") Long id) {
        Dojo dojo = dojoService.findDojo(id);
        String dojoName = dojo.getName();
        List<Ninja> ninjas = ninjaService.findByDojo(dojo);
        model.addAttribute("dojoName", dojoName);
        model.addAttribute("ninjas", ninjas);
        return "/views/dojoNinjas.jsp";
    }
}
