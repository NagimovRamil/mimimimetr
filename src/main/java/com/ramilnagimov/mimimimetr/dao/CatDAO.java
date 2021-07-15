package com.ramilnagimov.mimimimetr.dao;

import com.ramilnagimov.mimimimetr.entity.Cat;

import java.util.List;

public interface CatDAO {
    public List<Cat> getTopCats();
    public List<Cat> getAllCats();
}
