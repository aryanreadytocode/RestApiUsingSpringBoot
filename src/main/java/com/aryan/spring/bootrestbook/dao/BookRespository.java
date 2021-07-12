package com.aryan.spring.bootrestbook.dao;

import com.aryan.spring.bootrestbook.entities.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRespository extends CrudRepository<Book, Integer>{
    
    public Book findById(int id);
}
