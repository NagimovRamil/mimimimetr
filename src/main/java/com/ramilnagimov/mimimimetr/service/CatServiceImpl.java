package com.ramilnagimov.mimimimetr.service;


import com.ramilnagimov.mimimimetr.dao.CatDAO;
import com.ramilnagimov.mimimimetr.entity.Cat;
import com.ramilnagimov.mimimimetr.util.CatQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

@Service
public class CatServiceImpl implements CatService {
    @Autowired
    private CatDAO catDAO;
    @Autowired
    private CatQueue catQueue;

    public CatServiceImpl(CatQueue catQueue, CatDAO catDAO) {
        this.catQueue = catQueue;
        this.catDAO = catDAO;
    }
//    {
//
//        List<Cat> allCats = catDAO.getAllCats();
//        Collections.shuffle(allCats);
//        PriorityQueue<Cat> catQueue1 = new PriorityQueue<>();
//        PriorityQueue<Cat> catQueue2 = new PriorityQueue<>();
//        for (int i = 0; i < allCats.size(); i++) {
//            for (int j = i + 1; j < allCats.size(); j++) {
//                if (allCats.get(i).equals(allCats.get(j)) || catQueue1.contains(allCats.get(j)) || catQueue2.contains(allCats.get(i)))
//                    continue;
//                else {
//                    catQueue1.add(allCats.get(i));
//                    catQueue2.add(allCats.get(j));
//                }
//            }
//        }
//
//    }

    @Override
    @Transactional
    public List<Cat> getTopCats() {
        return catDAO.getTopCats();
    }

    @Override
    @Transactional
    public List<Cat> getListOfCats() {
        PriorityQueue<Cat> catQueue1 = catQueue.getQueuesOfCats().get(0);
        PriorityQueue<Cat> catQueue2 = catQueue.getQueuesOfCats().get(1);
        List<Cat> cats = new ArrayList<>();
        cats.add(catQueue1.poll());
        cats.add(catQueue2.poll());
        return cats;
//        if(!catQueue1.isEmpty() && !catQueue2.isEmpty()){

//        }

    }

//
//    List<Cat> allCats = catDAO.getAllCats();
//        Collections.shuffle(allCats);
//    LinkedHashSet<Cat> catQueue1 = new LinkedHashSet<>();
//    LinkedHashSet<Cat> catQueue2 = new LinkedHashSet<>();
//        for (int i = 0; i < allCats.size(); i++) {
//        for (int j = i+1; j < allCats.size(); j++) {
//            if(allCats.get(i).equals(allCats.get(j))) continue;
//            else {
//                catQueue1.add(allCats.get(i));
//                catQueue2.add(allCats.get(j));
//            }
//        }
//    }
//        for(Cat cat: catQueue1) {
//        Cat cat1 = cat;
//        }
//        for(Cat cat: catQueue2) {
//        Cat cat2 = cat;
//        }
//
//}

}
