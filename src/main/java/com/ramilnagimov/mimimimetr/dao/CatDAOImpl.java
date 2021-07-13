package com.ramilnagimov.mimimimetr.dao;

import com.ramilnagimov.mimimimetr.entity.Cat;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CatDAOImpl implements CatDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Cat> getAllCats() {

        Session session = entityManager.unwrap(Session.class);
        List<Cat> allCats = session.createQuery("from Cat", Cat.class).getResultList();

        return allCats;
    }
}

























