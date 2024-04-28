package com.Spring.CRUD.Operation.Entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int BookId;
    
    @Column(name="title")
	private String title;
	
	private String author;
	
	private LocalDate PublishedDate;
	
	private int edition;
	
	public long getBookId() {
		return BookId;
	}
	public void setBookId(int bookId) {
		BookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public LocalDate getPublishedDate() {
		return PublishedDate;
	}
	public void setPublishedDate(LocalDate localDate) {
		PublishedDate = localDate;
	}
	
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public Book(int bookId, String title, String author, LocalDate publishedDate,int edition) {
		super();
		BookId = bookId;
		this.title = title;
		this.author = author;
		PublishedDate = publishedDate;
		this.edition=edition;
	}
	public Book() {
		super();
	}
	
	
}
