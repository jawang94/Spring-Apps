package com.wang.routing.routingpractice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class HomeController {
    @RequestMapping("/dojo")
    public String hello() {
        return "Hello dojo!";
    }
    @RequestMapping("/python")
    public String python() {
        return "we love python!";
    }
    @RequestMapping("/java")
    public String java() {
        return "i love java!";
    }
}