package com.niit.bej.user.auth.security;

import com.niit.bej.user.auth.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtSecurityTokenGenerator implements SecurityTokenGenerator {

    @Override
    public Map<String, String> generateToken(User user) {
        Map<String, Object> claimsMap = new HashMap<>();
        claimsMap.put("username", user.getUsername());
        String jsonWebToken = Jwts
                .builder()
                .setIssuedAt(new Date())
                .setIssuer("user-auth-service")
                .setSubject(user.getUsername())
                .setClaims(claimsMap)
                .signWith(SignatureAlgorithm.HS256, "password")
                .compact();
        return Map.of(
                "token", jsonWebToken,
                "message", user.getUsername() + " logged in successfully!"
        );
    }
}
