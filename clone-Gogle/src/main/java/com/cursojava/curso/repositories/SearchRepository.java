package com.cursojava.curso.repositories;

import com.cursojava.curso.entities.WebPage;

import java.util.List;

public interface SearchRepository {
    List<WebPage> search(String query);

    void save(WebPage page);

    boolean isNotExistUrl(String link);

    List<WebPage> getLinkToindex();
}
