package com.bookmyshow.bookmyshow.service;

import com.bookmyshow.bookmyshow.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    List<User> getAllUsers();
}
