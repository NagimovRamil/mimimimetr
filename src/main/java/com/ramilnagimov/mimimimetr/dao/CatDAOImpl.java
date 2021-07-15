package com.ramilnagimov.mimimimetr.dao;

import com.ramilnagimov.mimimimetr.entity.Cat;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CatDAOImpl implements CatDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Cat> getTopCats() {

        Session session = entityManager.unwrap(Session.class);
        List<Cat> allCats = session.createQuery("from Cat", Cat.class).getResultList();
        Collections.sort(allCats, Collections.reverseOrder());
        List<Cat> topCats = allCats.stream().limit(10).collect(Collectors.toList());

        return topCats;
    }
    @Override
    public List<Cat> getAllCats() {

        Session session = entityManager.unwrap(Session.class);
        List<Cat> allCats = session.createQuery("from Cat", Cat.class).getResultList();

        return allCats;
    }
}

























