package com.cfs.SpringSecurity04.dto;

import com.cfs.SpringSecurity04.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String username;
    private String password;
    private List<String> roles;
}
