package com.ramilnagimov.mimimimetr.service;


import com.ramilnagimov.mimimimetr.entity.Cat;

import java.util.List;
import java.util.PriorityQueue;

public interface CatService {

    public List<Cat> getTopCats();
//    public List<PriorityQueue<Cat>> getQueuesOfCats();
    public List<Cat> getListOfCats();
}
