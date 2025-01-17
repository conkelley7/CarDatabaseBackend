package com.kelley.cardatabase.domain.service;

import java.security.Key;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Just as a note for myself for the future:
 * It would be better to make a JwtService interface and implement it here as JwtServiceImpl.
 * By separating the interface and implementation, I can allow the service to focus solely on what needs to be done (e.g., generate a JWT, validate a JWT) 
 * without tying the business logic to a specific implementation. This is key to achieving abstraction.
 */
@Service
public class JwtService {
	// 1 day in MS. Should be shortened in production.
	static final long EXPIRATION_TIME = 86400000;
	static final String PREFIX = "Bearer";
	
	/*
	 * Generate a secret key using secretKeyFor().
	 * This is only for demonstration purposes!
	 * In a real production application, the secret key should be read from application configuration.
	 */
	static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	/* 
	 * Generate signed JWT token
	 */
	public String getToken(String username) {
		String token = Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)).signWith(key).compact();
		
		return token;
	}
	
	/*
	 * Get a token from request Authorization header, verify token, and get username.
	 */
	public String getAuthUser(HttpServletRequest request) {
		String token = request.getHeader(HttpHeaders.AUTHORIZATION);
		
		if (token != null) {
			String user = Jwts.parserBuilder()
					.setSigningKey(key)
					.build()
					.parseClaimsJws(token.replace(PREFIX, ""))
					.getBody()
					.getSubject();
			
			if (user != null) {
				return user;
			}
		}
		return null;
	}
	
}
