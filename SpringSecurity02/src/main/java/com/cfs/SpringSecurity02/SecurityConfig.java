package com.cfs.SpringSecurity02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> auth

                        // PUBLIC APIs (No login required)
                        .requestMatchers("/", "/api/about", "/api/contact").permitAll()

                        // SECURED APIs (Login required)
                        .requestMatchers("/api/transfer", "/api/admin").authenticated()
                )
                // Authentication type → HTTP Basic
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}

