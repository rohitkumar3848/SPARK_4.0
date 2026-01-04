package com.bookmyshow.bookmyshow.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

//    FLOW--
//    Yahan kya ho raha hai?
//
//    generateToken() → login ke baad call hota
//
//    extractClaims() → har secured request pe call hota
//
//    Signature + Expiry auto verify hoti hai


    // 🔐 Secret key (minimum 256-bit for HS256)
    private static final String SECRET =
            "bookmyshow-super-secure-jwt-secret-key-256-bit";

    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    // =========================
    // GENERATE TOKEN
    // =========================
    public String generateToken(String email, String role, Long userId) {

        return Jwts.builder()
                .setSubject(email)              // unique identity
                .claim("role", role)            // USER / ADMIN
                .claim("userId", userId)        // used in booking
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000)
                ) // 1 day
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // =========================
    // VALIDATE + PARSE TOKEN
    // =========================
    public Claims extractClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
