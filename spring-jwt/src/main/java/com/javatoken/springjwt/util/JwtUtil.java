package com.javatoken.springjwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {
    private String SECRET_KEY = "mochiko";

    // getting the username from the token
    public String extractionUserName(String token){
        return extractionClaim(token, Claims::getSubject);
    }
    // getting the expiration date
    public Date extractExpiration(String token) {
        return extractionClaim(token, Claims::getExpiration);
    }

    // extracting the claim.
    public <T> T extractionClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractionAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractionAllClaims(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    // taking the date and see if its before
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // takes the user details object from the class
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        //takes the user name from the userDetails object
        return createToken(claims, userDetails.getUsername());
    }
    // call the jwt api
    private String createToken(Map<String, Object> claims, String subject) {
        // setting the claims and subject (who was able to successfully login) + current date
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                // setting the expiration date 10 hours from now
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                // sign it with the secret key.
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    // validate if the user name is same as the token and if its not expired
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractionUserName(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
