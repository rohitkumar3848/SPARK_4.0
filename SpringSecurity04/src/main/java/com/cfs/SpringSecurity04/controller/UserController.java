package com.cfs.SpringSecurity04.controller;

import com.cfs.SpringSecurity04.dto.UserListRequest;
import com.cfs.SpringSecurity04.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUsers") //ALL
    public String addUsers(@RequestBody UserListRequest userListRequest){
        userService.saveUsers(userListRequest.getUsers());
        return "user added successfully";

    }

    @GetMapping("/public") // ALL
    public String publicApi() {
        return "Public API";
    }

    @GetMapping("/user") // User
    public String userApi() {
        return "USER API";
    }

    @GetMapping("/admin") // Admin
    public String adminApi() {
        return "ADMIN API";
    }
}
