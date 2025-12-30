package com.cfs.SpringSecurity03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurity03Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity03Application.class, args);
	}

//    Case 4 Summary:
//            - application.properties user NOT used
//- Multiple in-memory users created
//- Roles assigned: ADMIN, USER
//- Passwords encoded using BCrypt
//- URL security checks authentication
//- Method security checks authorization
//- @EnableMethodSecurity enables role checks
//- @PreAuthorize used on service methods
    //In this setup, URL-based security ensures authentication, while method-level security using @PreAuthorize enforces role-based authorization at the service layer, which is a recommended best practice.
    
}
