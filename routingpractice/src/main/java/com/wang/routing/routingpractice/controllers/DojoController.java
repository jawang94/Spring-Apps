package com.wang.routing.routingpractice.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DojoController {
    @RequestMapping("/{string}")
    public String showMessage(@PathVariable("string") String string){
        if (string == "dojo") {
            return "The dojo is awesome!;
        }
        if (string == "burbank-dojo") {
            return "Burbank Dojo is located in Southern California.";
        }
        if (string == "san-jose" ) {
            return "SJ dojo is the headquarters.";
        }
    }
}
