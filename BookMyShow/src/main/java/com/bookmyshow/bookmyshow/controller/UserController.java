package com.bookmyshow.bookmyshow.controller;

import com.bookmyshow.bookmyshow.entity.Movie;
import com.bookmyshow.bookmyshow.entity.User;
import com.bookmyshow.bookmyshow.service.UserService;
import com.bookmyshow.bookmyshow.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    // CREATE USER
    @PostMapping
    public User createUser(@Valid @RequestBody User user){
        return userService.createUser(user);
    }

    // GET ALL USERS
    @GetMapping
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }


}
