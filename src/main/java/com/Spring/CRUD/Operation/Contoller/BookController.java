package com.Spring.CRUD.Operation.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.CRUD.Operation.Entity.Book;
import com.Spring.CRUD.Operation.Service.BookService;




@RestController
public class BookController {

	@Autowired
	BookService bookservice;
	
	@GetMapping("/listAllBooks")
	public ResponseEntity<List<Book>> getAllBook(){
		List<Book> book=this.bookservice.getAllBook();
		return new ResponseEntity<>(book,HttpStatus.OK);
	}
	
	@PostMapping("/addBook")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		return new ResponseEntity<Book>(bookservice.addbook(book),HttpStatus.CREATED);
	}
	
	@GetMapping("/getBook/{id}")
	public ResponseEntity<Book> getBookbyId(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(bookservice.getBookById(id),HttpStatus.OK);
	}
	
	@GetMapping("/filterBookbyTitle")
	public ResponseEntity<Book> getBookbytitle(@RequestParam String title){
		return new ResponseEntity<>(bookservice.getBookbyTitle(title),HttpStatus.OK);
	}
	
	@GetMapping("/filterBook")
	public ResponseEntity<List<Book>> getBookbyAuthor(@RequestParam String author){
		return new ResponseEntity<>(bookservice.getBookbyAuthor(author),HttpStatus.OK);
	}
	
	@PutMapping("/updateBook/{id}")
	public ResponseEntity<Book> updateBookbyId(@PathVariable(value="id") int id,@RequestBody Book book){
		return new ResponseEntity<>(bookservice.updateBook(book, id),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deletebook/{id}")
	public ResponseEntity<?> deletebook(@PathVariable(value="id")int id) {
		this.bookservice.deletebookbyId(id);
		return new ResponseEntity<>("Successfully Deleted",HttpStatus.OK);
	}
	
	
	
}
