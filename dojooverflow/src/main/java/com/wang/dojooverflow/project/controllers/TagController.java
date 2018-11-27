package com.wang.dojooverflow.project.controllers;

import com.wang.dojooverflow.project.models.Question;
import com.wang.dojooverflow.project.models.Tag;
import com.wang.dojooverflow.project.services.QuestionService;
import com.wang.dojooverflow.project.services.TagService;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class TagController {
    @Autowired
    private final QuestionService questionService;
    private final TagService tagService;

    public TagController(QuestionService questionService, TagService tagService) {
        this.questionService = questionService;
        this.tagService = tagService;
    }



}
