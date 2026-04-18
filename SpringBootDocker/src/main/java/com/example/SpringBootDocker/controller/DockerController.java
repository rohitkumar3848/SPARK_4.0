package com.example.SpringBootDocker.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DockerController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Rohit! Your Spring Boot App is running successfully.";
    }
}