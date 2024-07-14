package com.vitaminncpp.chess.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;


@Service
public class JwtService {

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails user, Map<String, Object> extraClaims) {
        return Jwts.builder().claims().add(extraClaims).and().issuer("com.vitaminncpp.chess").subject(user.getUsername()).audience().add(user.getUsername()).and().expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7)).issuedAt(new Date(System.currentTimeMillis())).id(UUID.randomUUID().toString()).signWith(getSecretKey()).compact();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().verifyWith(getSecretKey()).build().parseSignedClaims(token).getPayload();
    }

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor("secret".getBytes());
    }

    public boolean isTokenValid(String token, UserDetails user) {
        final String username = extractUsername(token);
        return user.getUsername().equals(username) && isTokenNonExpired(token);
    }

    public boolean isTokenNonExpired(String token) {
        final Date expiration = extractClaim(token, Claims::getExpiration);
        return expiration.before(new Date());
    }
}
