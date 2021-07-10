package com.aryan.spring.bootrestbook.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import com.aryan.spring.bootrestbook.entities.Book;
import com.aryan.spring.bootrestbook.services.BookServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Jackson library is used to change java object to json 
 * structure
 */
@RestController
public class BookController {

    @Autowired
    private BookServices bookServices;

    // @RequestMapping(value = "/books", method = RequestMethod.GET)
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){ 
        // Book book = new Book(100, "Java Complete Reference", "Narayan murthy");
        // return book;
        List<Book> book = bookServices.getAllBooks();
        if(book.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id){ 
        // Book book = new Book(100, "Java Complete Reference", "Narayan murthy");
        // return book;
        Book b = bookServices.getSingleBook(id);
        if(b == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(b));
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book b = null;
        try {
            b = bookServices.addBook(book); 
            System.out.println(b);
            return ResponseEntity.of(Optional.of(b));
        } catch (Exception e) {
            //
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId){
        try {
            this.bookServices.deleteBook(bookId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PutMapping("/books/{bookId}")
    public ResponseEntity<Void> updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId){
        try {
           this.bookServices.updateBook(book, bookId);
           return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
