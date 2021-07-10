package com.aryan.spring.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.aryan.spring.bootrestbook.entities.Book;
import org.springframework.stereotype.Component;

@Component
public class BookServices {

    private static List<Book> books = new ArrayList<>();

    
    static {
        books.add(new Book(100, "Java Development Complete Cources", "Jitendra Shaw"));
        books.add(new Book(101, "Android Development Complete Cources", "Rahul Jaishwal"));
        books.add(new Book(102, "Python Development Complete Cources", "Anurag Gupta"));
    }

    // get all books
    public List<Book> getAllBooks(){
        return books;
    }

    public Book getSingleBook(int id){
        Book book = null;
        try{
            book = books.stream().filter(s -> s.getId()==id).findFirst().get();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return book;
    }

    public Book addBook(Book book){
        books.add(book);
        return book;
    }

    public void deleteBook(int bookId){
        books = books.stream().filter(book -> book.getId()!=bookId).collect(Collectors.toList());
    }

    public void updateBook(Book book, int bookId){
        books = books.stream().map(b -> {
            if(b.getId() == bookId){
                b.setAuthor(book.getAuthor());
                b.setTitle(book.getTitle());
            }
            return b;
        }).collect(Collectors.toList());
    }
    
}
