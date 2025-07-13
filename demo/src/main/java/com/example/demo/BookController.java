package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

	private final BookService bookService;
	
	public BookController(BookService bookService) {
        this.bookService = bookService;
}
	@GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }	

}

