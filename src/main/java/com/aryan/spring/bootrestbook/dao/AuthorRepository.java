package com.aryan.spring.bootrestbook.dao;

import com.aryan.spring.bootrestbook.entities.Author;

import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer>{
    
}
