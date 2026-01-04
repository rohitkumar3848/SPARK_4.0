package com.bookmyshow.bookmyshow.controller;

import com.bookmyshow.bookmyshow.entity.User;
import com.bookmyshow.bookmyshow.repository.UserRepository;
import com.bookmyshow.bookmyshow.security.jwt.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

//    Email + Password
//→ DB check
//→ Password match
//→ JWT create
//→ Client ko return

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder,
                          JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // =========================
    // LOGIN API
    // =========================
    @PostMapping("/login")
    public String login(@RequestBody User loginRequest) {

        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!passwordEncoder.matches(
                loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // 🔑 JWT generate
        return jwtUtil.generateToken(
                user.getEmail(),
                user.getRole(),
                user.getId()
        );
    }

    @PostMapping("/logout")
    public String logout() {
        return "Logout successful. Please delete token on client side.";
    }

}
