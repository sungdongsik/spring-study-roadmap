package com.project.spring_study_roadmap.glabal.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "qwF0r-hPgW301pEr756XZ2EVMz4zFH1hBawdJY92DQg";
    private final long ACCESS_TOKEN_EXPIRE = 1000 * 60 * 15;  // 15분
    private final long REFRESH_TOKEN_EXPIRE = 1000 * 60 * 60 * 24 * 7;  // 7일

    public String createAccessToken(String username) {
        return createToken(username, ACCESS_TOKEN_EXPIRE);
    }

    public String createRefreshToken(String username) {
        return createToken(username, REFRESH_TOKEN_EXPIRE);
    }

    private String createToken(String username, long expireTime) {
        Date now = new Date();
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + expireTime))
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(SECRET_KEY.getBytes()).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
