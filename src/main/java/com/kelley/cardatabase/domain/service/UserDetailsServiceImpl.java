package com.kelley.cardatabase.domain.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kelley.cardatabase.domain.model.AppUser;
import com.kelley.cardatabase.domain.repository.AppUserRepository;

/**
 * Implements Spring Security's 'UserDetailsService' interface for user authentication and authorization.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private final AppUserRepository appUserRepository;
	
	public UserDetailsServiceImpl(AppUserRepository appUserRepository) {
		this.appUserRepository = appUserRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<AppUser> user = appUserRepository.findByUsername(username);
		
		UserBuilder builder = null;
		
		if (user.isPresent()) {
			AppUser currentUser = user.get();
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(currentUser.getPassword());
			builder.roles(currentUser.getRole());
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
		
		return builder.build();
		
	}
	
}