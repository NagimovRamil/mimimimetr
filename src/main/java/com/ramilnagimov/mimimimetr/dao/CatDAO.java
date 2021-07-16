package com.ramilnagimov.mimimimetr.dao;

import com.ramilnagimov.mimimimetr.entity.Cat;

import java.util.List;

public interface CatDAO {
    List<Cat> getTopCats();

    List<Cat> getAllCats();

    void updateCatScore(int id);

    int getCatsScoreByID(int id);
}
