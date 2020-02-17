package com.fishky.security.service;

import com.fishky.security.config.JwtSecret;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Date;

public class AuthenticationService {
    static final long EXPIRATIONTIME = 21_600_000;
    static final String PREFIX = "Bearer";

    static public void addToken(HttpServletResponse res, String username) {
        String JwtToken = Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, JwtSecret.SECRET)
                .compact();
        res.addHeader("Authorization", PREFIX + " " + JwtToken);
        res.addHeader("Access-Control-Expose-Headers", "Authorization");
    }

    static public UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            String user = decodeTokenIntoUsername(request);
            if (user != null)
                return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
        }
        return null;
    }

    public static String decodeTokenIntoUsername(HttpServletRequest request) {
        return Jwts.parser()
                        .setSigningKey(JwtSecret.SECRET)
                        .parseClaimsJws(request
                                .getHeader("Authorization")
                                .replace(PREFIX, ""))
                        .getBody()
                        .getSubject();
    }
}