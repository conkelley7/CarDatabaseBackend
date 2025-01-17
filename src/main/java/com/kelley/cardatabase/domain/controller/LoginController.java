package com.kelley.cardatabase.domain.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kelley.cardatabase.domain.service.JwtService;

@RestController
public class LoginController {
	
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	
	public LoginController(JwtService jwtService, AuthenticationManager authenticationManager) {
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
	}
	
	/**
	 * Generates token and sends in the response authorization header.
	 */
	@PostMapping("/login")
	public ResponseEntity<?> getToken() {
		// TODO
		return null;
	}
}
