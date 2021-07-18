package com.aryan.spring.bootrestbook.services;

import java.util.List;

import com.aryan.spring.bootrestbook.dao.AuthorRepository;
import com.aryan.spring.bootrestbook.entities.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorService {

    @Autowired
    private AuthorRepository authorRespository;

    // get all books
    public List<Author> getAllAuthors(){
        List<Author> list = (List<Author>) this.authorRespository.findAll();
        return list;
    }
    
}
