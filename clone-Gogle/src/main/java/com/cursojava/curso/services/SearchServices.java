package com.cursojava.curso.services;

import com.cursojava.curso.entities.WebPage;
import com.cursojava.curso.repositories.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Service
public class SearchServices {
    @Autowired
    SearchRepository repository;
    public List<WebPage> search(String query){
        return  repository.search(query);
 }

    public boolean isNotExist(String link) {
        return  repository.isNotExistUrl(link);
    }

    public List<WebPage> getLinkToindex() {
        return repository.getLinkToindex();
    }
}
