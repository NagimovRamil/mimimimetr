package com.ramilnagimov.mimimimetr.dao;

import com.ramilnagimov.mimimimetr.entity.Cat;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CatDAOImpl implements CatDAO {

    private final EntityManager entityManager;

    public CatDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Cat> getTopCats() {
        List<Cat> topCats = entityManager.createQuery("FROM Cat ORDER BY score DESC", Cat.class).setMaxResults(10).getResultList();
        return topCats;
    }

    @Override
    public List<Cat> getAllCats() {
        List<Cat> allCats = entityManager.createQuery("FROM Cat", Cat.class).getResultList();
        return allCats;
    }

    @Override
    @Modifying
    @Transactional
    public void updateCatScore(@Param("id") Long id) {
        Query updateScore = entityManager.createQuery("UPDATE Cat SET score = score+1 WHERE id = :idOfUpdatingCat").setParameter("idOfUpdatingCat", id);
        updateScore.executeUpdate();
    }
}

























