package com.cfs.SpringBootJP02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication =
// @Configuration + @EnableAutoConfiguration + @ComponentScan
// Ye annotation Spring Boot app ko start karne ke liye hota hai
@SpringBootApplication
public class SpringBootJp02Application {

	public static void main(String[] args) {
        // Yahin se Spring Boot app start hoti hai
        // Server start + Beans create + DB connect
        SpringApplication.run(SpringBootJp02Application.class, args);
	}

}
