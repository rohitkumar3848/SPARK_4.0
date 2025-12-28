package com.bookmyshow.bookmyshow.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                // REST APIs → CSRF not needed
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth

                        // =========================
                        // USER APIs
                        // =========================

                        // Signup (PUBLIC)
                        .requestMatchers(HttpMethod.POST, "/api/users").permitAll()

                        // Get all users (ADMIN only)
                        .requestMatchers(HttpMethod.GET, "/api/users").hasRole("ADMIN")

                        // =========================
                        // THEATRE APIs
                        // =========================

                        // Fetch theatres (PUBLIC)
                        .requestMatchers(HttpMethod.GET, "/api/theatres/**").permitAll()

                        // Add theatre (ADMIN)
                        .requestMatchers(HttpMethod.POST, "/api/theatres/**").hasRole("ADMIN")

                        // =========================
                        // MOVIE APIs
                        // =========================

                        // Fetch movies (PUBLIC)
                        .requestMatchers(HttpMethod.GET, "/api/movies/**").permitAll()

                        // Add movie (ADMIN)
                        .requestMatchers(HttpMethod.POST, "/api/movies/**").hasRole("ADMIN")

                        // =========================
                        // SHOW APIs
                        // =========================

                        // Fetch shows by city (PUBLIC)
                        .requestMatchers(HttpMethod.GET, "/api/shows/**").permitAll()

                        // Add show (ADMIN)
                        .requestMatchers(HttpMethod.POST, "/api/shows/**").hasRole("ADMIN")

                        // =========================
                        // BOOKING APIs
                        // =========================

                        // Book show (USER)
                        .requestMatchers(HttpMethod.POST, "/user/bookings/**").hasRole("USER")

                        // Get booking by user (USER + ADMIN)
                        .requestMatchers(HttpMethod.GET, "/user/bookings/**")
                        .hasAnyRole("USER", "ADMIN")

                        // =========================
                        // DEFAULT RULE
                        // =========================

                        .anyRequest().authenticated()
                )

                // HTTP Basic Auth (Spring Security 6+)
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
