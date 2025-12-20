package com.cfs.SpringBoot04.controller;

import com.cfs.SpringBoot04.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/welcome")
    public String dataFetchFromAPI(){
        return   studentService.getStudentData();
    }


}
