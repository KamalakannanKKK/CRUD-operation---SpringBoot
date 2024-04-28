package com.Spring.CRUD.Operation.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.stereotype.Service;

import com.Spring.CRUD.Operation.Entity.Book;
import com.Spring.CRUD.Operation.Exception.NoDataFoundException;
import com.Spring.CRUD.Operation.Exception.ResourceNotFoundException;
import com.Spring.CRUD.Operation.Repository.BookRepository;


@Service
public class BookService {

	@Autowired
	BookRepository bookrepository;
	
	public List<Book> getAllBook(){
		List<Book> book=this.bookrepository.findAll();
		if(book.isEmpty()) {
			throw new NoDataFoundException("Book List is Empty");
		}
		return book;
	}
	
	public Book addbook(Book book) {
		book.setPublishedDate(LocalDate.now());
		book.setAuthor(book.getAuthor().toLowerCase());
		book.setTitle(book.getTitle().toLowerCase());
		return bookrepository.save(book);
	}
	
	public Book getBookById(int id) {
		return this.bookrepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Enter Correct Book Id..."));
	}
	
	public Book getBookbyTitle(String title) {
	 Book book1=this.bookrepository.FindByBookTitle(title.toLowerCase());
	 if(book1==null) {
		 throw new ResourceNotFoundException(title+ ": Book Not Found..Enter Correct Title :) ");
	 }
	 return book1;
	}
	
	public List<Book> getBookbyAuthor(String Author){
		List<Book> book=bookrepository.getBookByAuthor(Author.toLowerCase());
		if(book.isEmpty()) {
			throw new NoDataFoundException(Author+": Author Not Found or Check Author Detail...");
		}
		return book;
	}
	
	public Book updateBook(Book book,int id) {
		Book book1=this.bookrepository.findById(id).get();
		if(book1==null) {
			throw new ResourceNotFoundException("Enter Correct Book Id....\n"+"Details Not Updated :( ");
		}
		book1.setTitle(book.getTitle().toLowerCase());
		book1.setAuthor(book.getAuthor().toLowerCase());
		book1.setEdition(book.getEdition());
		book1.setPublishedDate(LocalDate.now());
		return book1;
		
	}
	public void deletebookbyId(int id) {
		this.bookrepository.deleteById(id);
	}
}
