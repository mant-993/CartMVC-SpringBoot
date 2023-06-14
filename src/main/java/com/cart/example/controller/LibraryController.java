package com.cart.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cart.example.library.Book;
import com.cart.example.library.BookRepository;
import java.util.List;
import java.util.ArrayList;

@Controller
public class LibraryController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping(value="/library")
	public String library(Model model) {
		
		List<Book> books = new ArrayList<Book>();
		bookRepository.findAll().forEach(b -> books.add(b));
		model.addAttribute("books", books);
		return "library";
	}
	
	@PostMapping(value="/library")
	public String addBook(@ModelAttribute Book book, Model model) {
		bookRepository.save(book);
		return "redirect:/library";
	}
	
	@DeleteMapping(value = "/library/{bookid}")  
	public String deleteBook(@PathVariable("bookid") Long bookid)   
	{  
		try {
			bookRepository.deleteById(bookid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/library";
	}



}
