package in.leucine.utils;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import in.leucine.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    //@Value("${jwt.secret}")
    private String secretKey;

    //@Value("${jwt.expiration}")
    private long expirationTime; // e.g., 86400000 for 1 day

    public String generateToken(User user) {
        logger.info("Generating JWT for user: {}", user.getUsername());
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("role", user.getRole())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            logger.warn("JWT Token has expired: {}", e.getMessage());
            return false;
        } catch (Exception e) {
            logger.error("JWT Token validation error: {}", e.getMessage());
            return false;
        }
    }

    public String extractUsername(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
            return claims.getSubject();
        } catch (Exception e) {
            logger.error("Error extracting username from token: {}", e.getMessage());
            return null;
        }
    }
}