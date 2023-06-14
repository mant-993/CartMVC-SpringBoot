package com.cart.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.cart.example.library.Book;
import com.cart.example.library.BookRepository;
import com.cart.example.users.UserRepository;
import com.cart.example.users.Users;

@Component
public class DataLoader implements ApplicationRunner {

    private BookRepository bookRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public DataLoader(BookRepository bookRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void run(ApplicationArguments args) {
    	
    	bookRepository.save(new Book(01l, "Alessandro Manzoni", "I Promessi Sposi", "Romanzo", 13.45));
    	bookRepository.save(new Book(02l, "Book A", "Title A", "Tragedia", 20.99));
    	bookRepository.save(new Book(03l, "Book B", "Title B", "Avventura", 8.79));
    	bookRepository.save(new Book(04l, "Book C", "Title C", "Romanzo", 11.50));
    	
    	userRepository.save(new Users(00l, "root", passwordEncoder.encode("root"), "fullname", "street", "city", "state", "zip", "phoneNumber"));
    	
    	
    }
}