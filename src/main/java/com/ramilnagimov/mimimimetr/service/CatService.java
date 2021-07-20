package com.ramilnagimov.mimimimetr.service;


import com.ramilnagimov.mimimimetr.entity.Cat;

import java.util.List;

public interface CatService {

    List<Cat> getTopCats();

    List<Cat> fetchNextPairOfCats();

    void updateCatScore(Long id);
}
