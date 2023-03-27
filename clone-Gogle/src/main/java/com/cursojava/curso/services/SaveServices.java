package com.cursojava.curso.services;

import com.cursojava.curso.entities.WebPage;
import com.cursojava.curso.repositories.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveServices {
 @Autowired
    SearchRepository repository;
 public void save(WebPage page){
    repository.save(page);
 }
}
