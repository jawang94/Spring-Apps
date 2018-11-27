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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class NinjaController {
    @Autowired
    private final NinjaService ninjaService;
    private final DojoService dojoService;

    public NinjaController (NinjaService ninjaService, DojoService dojoService) {
        this.ninjaService = ninjaService;
        this.dojoService = dojoService;
    }

    @RequestMapping("/ninjas/new")
    public String newNinja(Model model, @ModelAttribute("ninja") Ninja ninja) {
        List<Dojo> dojos = dojoService.findAll();
        model.addAttribute("dojos", dojos);
        return "/views/newNinja.jsp";
    }

    @RequestMapping(value="/ninjas/new", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/ninjas/new";
        } else {
            ninjaService.createNinja(ninja);
            return "redirect:/ninjas/new";
        }
    }
}
