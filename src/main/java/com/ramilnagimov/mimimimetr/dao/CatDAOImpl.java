package com.ramilnagimov.mimimimetr.dao;

import com.ramilnagimov.mimimimetr.entity.Cat;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CatDAOImpl implements CatDAO {

    private final EntityManager entityManager;

    public CatDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Cat> getTopCats() {
        Session session = entityManager.unwrap(Session.class);
        List<Cat> allCats = session.createQuery("from Cat", Cat.class).getResultList();
        allCats.sort(Collections.reverseOrder());
        List<Cat> topCats = allCats.stream().limit(10).collect(Collectors.toList());

        return topCats;
    }

    @Override
    public List<Cat> getAllCats() {
        Session session = entityManager.unwrap(Session.class);
        List<Cat> allCats = session.createQuery("from Cat", Cat.class).getResultList();

        return allCats;
    }

    @Override
    @Modifying
    @Transactional
    public void updateCatScore(@Param("id") Long id) {
        Session session = entityManager.unwrap(Session.class);
        Query updateScore = session.createQuery("update Cat set score = score+1 where id = :idOfUpdatingCat").setParameter("idOfUpdatingCat", id);
        updateScore.executeUpdate();
    }
}

























