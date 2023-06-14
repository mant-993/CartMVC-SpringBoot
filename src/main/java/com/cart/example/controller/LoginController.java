package com.cart.example.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cart.example.security.RegistrationForm;
import com.cart.example.users.UserRepository;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	
	@GetMapping
	public String loginForm() {
		return "login";
	}

}