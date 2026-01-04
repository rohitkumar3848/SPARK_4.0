package com.bookmyshow.bookmyshow.security;

import com.bookmyshow.bookmyshow.security.jwt.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                // =========================
                // CSRF
                // =========================
                .csrf(csrf -> csrf.disable())

                // =========================
                // AUTHORIZATION RULES
                // =========================
                .authorizeHttpRequests(auth -> auth

                        // ---------- AUTH ----------
                        .requestMatchers("/auth/**").permitAll()

                        // ---------- USER ----------
                        .requestMatchers(HttpMethod.POST, "/api/users").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/users").hasRole("ADMIN")

                        // ---------- THEATRE ----------
                        .requestMatchers(HttpMethod.GET, "/api/theatres/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/theatres/**").hasRole("ADMIN")

                        // ---------- MOVIE ----------
                        .requestMatchers(HttpMethod.GET, "/api/movies/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/movies/**").hasRole("ADMIN")

                        // ---------- SHOW ----------
                        .requestMatchers(HttpMethod.GET, "/api/shows/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/shows/**").hasRole("ADMIN")

                        // ---------- BOOKING ----------
                        .requestMatchers(HttpMethod.POST, "/user/bookings/**").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/user/bookings/**")
                        .hasAnyRole("USER", "ADMIN")

                        // ---------- DEFAULT ----------
                        .anyRequest().authenticated()
                )

                // =========================
                // JWT FILTER
                // =========================
                .addFilterBefore(
                        jwtAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class
                );

        return http.build();
    }
}
