package com.cart.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.cart.example.users.Users;
import com.cart.example.users.UserRepository;

import java.util.*;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService(UserRepository userRepo) {
		return username -> {
			Users user = userRepo.findByUsername(username);
			if (user != null) return user;
			throw new UsernameNotFoundException("User '" + username + "' not found");
		};
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests()
					.requestMatchers("/library").hasRole("USER")
					.requestMatchers("/", "/**").permitAll()
				.and()
					.formLogin()
					.loginPage("/login")
					.defaultSuccessUrl("/")
				.and()
					.logout()
						.logoutSuccessUrl("/")
				.and()
				.build();
	}
	
	
}
