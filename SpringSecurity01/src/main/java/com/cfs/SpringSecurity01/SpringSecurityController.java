package com.cfs.SpringSecurity01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SpringSecurityController {

    @GetMapping("/bal")
    public String bal() {
        return "bal";
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
}
