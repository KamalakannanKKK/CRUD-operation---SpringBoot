package com.Spring.CRUD.Operation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Spring.CRUD.Operation.Entity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
     
	@Query("SELECT pl From Book pl WHERE pl.title=?1")
	Book FindByBookTitle(String title);

	@Query("SELECT pl From Book pl WHERE pl.author=?1")
	List<Book> getBookByAuthor(String author);

}
