package com.cursojava.curso.repositories;

import com.cursojava.curso.entities.WebPage;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SearchRepositoryImp implements SearchRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    @Override
    public List<WebPage> search(String inputServices) {

        String query = "FROM WebPage WHERE title LIKE :inputServices ";
        return entityManager.createQuery(query)
                .setParameter("inputServices",  "%" +inputServices+"%")
                .getResultList();
    }
    @Transactional
    @Override
    public void save(WebPage page) {
        entityManager.merge(page);
        return;
    }
    @Transactional
    @Override
    public boolean isNotExistUrl(String url){
        String query = "FROM WebPage WHERE url = :url";
        List<WebPage> listUrl = entityManager.createQuery(query)
                .setParameter("url", url)
                .getResultList();
        return  listUrl.size() == 0;
    }

    @Override
    public List<WebPage> getLinkToindex() {
        String query = "FROM WebPage WHERE title IS NULL AND description IS NULL";
        return entityManager.createQuery(query)
                .setMaxResults(10)
                .getResultList();
    }
}