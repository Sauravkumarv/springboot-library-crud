package com.example.demo;


import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	private final JdbcTemplate jdbcTemplate;
	
	public BookService(JdbcTemplate jdbcTemplate) {
		
		this.jdbcTemplate=jdbcTemplate;
	}
	
	private RowMapper<Book>bookRowMapper=(rs,rowNum)->new Book(
			 rs.getLong("id"),
			    rs.getString("title"),
			    rs.getString("author"),
			    rs.getString("genre"),
			    rs.getInt("publication_year")
	);		
	
	
	public List<Book> getAllBooks() {
        return jdbcTemplate.query("SELECT * FROM books", bookRowMapper);
    }
	
	public Book getBookById(Long id) {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books WHERE id = ?", bookRowMapper, id);
        return books.isEmpty() ? null : books.get(0);
    }
}
