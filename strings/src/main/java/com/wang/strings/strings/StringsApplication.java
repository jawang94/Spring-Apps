package com.wang.strings.strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
// 1. Annotation
@RestController
public class StringsApplication {
    public static void main(String[] args) {
        SpringApplication.run(StringsApplication.class, args);
    }

    @RequestMapping("/")
    public String hello() { // 3
        return "Hello brosif whatup witchu?!";
    }

    @RequestMapping("/random")
    public String wow() { // 3
        return "WOW SPRING BOOT FTWWW!!!!";
    }
}
