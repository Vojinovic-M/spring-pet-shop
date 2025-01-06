package com.example.backend.services;

import com.example.backend.entities.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
        @Value("${security.jwt.secret-key}")
        private String secretKey;

        @Value("${security.jwt.expiration-time}")
        private long jwtExpiration;

        public String extractUsername(String token) {
            return extractClaim(token, Claims::getSubject);
        }

        public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
            final Claims claims = extractAllClaims(token);
            return claimsResolver.apply(claims);
        }

        public String generateToken(UserEntity userEntity) {
            Map<String, Object> claims = new HashMap<>();

            claims.put("id", userEntity.getId());
            claims.put("email", userEntity.getEmail());
            claims.put("firstName", userEntity.getFirstName());
            claims.put("lastName", userEntity.getLastName());
            claims.put("phone", userEntity.getPhone());

            return generateToken(claims, userEntity.getEmail());
        }

        public String generateToken(Map<String, Object> extraClaims, String jwtSubject) {
            return buildToken(extraClaims, jwtSubject, jwtExpiration);
        }

        public long getExpirationTime() {
            return jwtExpiration;
        }

        private String buildToken(
                Map<String, Object> extraClaims,
                String jwtSubject,
                long expiration
        ) {
            return Jwts
                    .builder()
                    .setClaims(extraClaims)
                    .setSubject(jwtSubject)
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + expiration))
                    .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                    .compact();
        }

        public boolean isTokenValid(String token, UserDetails userDetails) {
            final String username = extractUsername(token);
            return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
        }

        private boolean isTokenExpired(String token) {
            return extractExpiration(token).before(new Date());
        }

        private Date extractExpiration(String token) {
            return extractClaim(token, Claims::getExpiration);
        }

        private Key getSignInKey() {
            byte[] keyBytes = Decoders.BASE64.decode(secretKey);
            return Keys.hmacShaKeyFor(keyBytes);
        }

        private Claims extractAllClaims(String token) {
            return Jwts
                    .parser()
                    .setSigningKey(getSignInKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        }


}
