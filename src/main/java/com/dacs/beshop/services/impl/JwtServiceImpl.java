package com.dacs.beshop.services.impl;

import com.dacs.beshop.services.JwtService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Service
public class JwtServiceImpl implements JwtService {
    private final String secretKey = "THEONLYWAYTODOGREATWORKISTOLOVEWHATYOUDOSPEDD1000KM";

    @Override
    public String extractEmail(String token) {
        return Jwts.parser().verifyWith(getSecretKey()).build().parseSignedClaims(token).getPayload().getSubject();
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .header().add(Map.of("alg", "HS256", "typ", "JWT")).and()
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() * 60 * 60 * 24))
                .signWith(getSecretKey())
                .compact();
    }

    @Override
    public String generateTokenRefresh(UserDetails userDetails) {
        return Jwts.builder()
                .header().add(Map.of("alg", "HS256", "typ", "JWT")).and()
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() * 60 * 60 * 24 * 7))
                .signWith(getSecretKey())
                .compact();
    }

    @Override
    public Boolean isTokenValid(String token) {
        return !isTokenExpiration(token);
    }

    private boolean isTokenExpiration(String token) {
        return Jwts.parser().verifyWith(getSecretKey()).build().parseSignedClaims(token).getPayload().getExpiration().before(new Date());
    }

    private SecretKey getSecretKey() {
        byte[] bytes = Base64.getDecoder().decode(secretKey);
        return Keys.hmacShaKeyFor(bytes);
    }
}
