package com.cfs.SpringSecurity02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurity02Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity02Application.class, args);
//        Spring Security Case 3:
//        - spring-boot-starter-security added
//                - Username & password defined in application.properties
//                - Custom SecurityFilterChain configured
//        - URL-based authorization
//                - Public APIs using permitAll()
//                - Secured APIs using authenticated()
//                - HTTP Basic authentication
//        - In-memory user with ROLE_USER
//        In this case, Spring Security uses credentials defined in application.properties along with a custom SecurityFilterChain to control access, where some APIs are publicly accessible and others require authentication
	}

}
