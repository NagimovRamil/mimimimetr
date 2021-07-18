package com.ramilnagimov.mimimimetr.dao;

import com.ramilnagimov.mimimimetr.entity.Cat;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
    public void updateCatScore(Long id) {

        Session session = entityManager.unwrap(Session.class);
//        Query query = session.createQuery("Update Cat SET score =: score where id =: id");
//        query.setParameter("score", getCatsScoreByID(id) + 1);
//        query.executeUpdate();
        Cat cat = session.createQuery("from Cat where id =: id", Cat.class).uniqueResult();
        cat.setScore(cat.getScore() + 1);
        session.saveOrUpdate(cat);
    }

    @Override
    public int getCatsScoreByID(Long id) {
        int score;
        Session session = entityManager.unwrap(Session.class);
        Cat cat = session.load(Cat.class, id);
        score = cat.getScore();

        return score;
    }
}

























