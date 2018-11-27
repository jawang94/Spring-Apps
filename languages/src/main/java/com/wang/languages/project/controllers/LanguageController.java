package com.wang.languages.project.controllers;

import com.wang.languages.project.models.Language;
import com.wang.languages.project.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
public class LanguageController {
    @Autowired
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @RequestMapping("/languages")
    public String index(Model model, @ModelAttribute("language") Language language) {
        List<Language> languages = languageService.findAll();
        model.addAttribute("languages", languages);
        return "/views/index.jsp";
    }

    @RequestMapping(value="/languages", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/languages";
        } else {
            languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String show(Model model, @PathVariable(value = "id") Long id) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "/views/show.jsp";
    }

    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "/views/edit.jsp";
    }

    @RequestMapping(value="/languages/{id}/update", method=RequestMethod.PUT)
    public String update(@PathVariable(value = "id") Long id, @Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/views/edit.jsp";
        } else {
            languageService.updateLanguage(language, id);
            return "redirect:/languages";
        }
    }

    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
}
