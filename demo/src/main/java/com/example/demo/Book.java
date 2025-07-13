package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {

	private Long id;
	private String title;
	private String author;
	private String genre;
	private int publication_year;

	
	
}
