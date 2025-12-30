package com.cfs.SpringSecurity02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SpringSecurityController {


    @GetMapping("/contact")
    public String contact() {
        return "Spring Security API contact";
    }

    @GetMapping("/transfer")
    public String transfer() {
        return "Spring Security API transfer";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Spring Security API admin";
    }

    @GetMapping("/about")
    public String about() {
        return "Spring Security API about";
    }
}

