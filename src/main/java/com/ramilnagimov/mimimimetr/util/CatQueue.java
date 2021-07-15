package com.ramilnagimov.mimimimetr.util;

import com.ramilnagimov.mimimimetr.dao.CatDAO;
import com.ramilnagimov.mimimimetr.entity.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

@Component
@SessionScope
public class CatQueue {

    private List<PriorityQueue<Cat>> cats = new ArrayList<>();
    @Autowired
    private CatDAO catDAO;

    @PostConstruct
    @Autowired
    public void initMethod() {
        List<Cat> allCats = catDAO.getAllCats();
        Collections.shuffle(allCats);
        PriorityQueue<Cat> catQueue1 = new PriorityQueue<>();
        PriorityQueue<Cat> catQueue2 = new PriorityQueue<>();
        for (int i = 0; i < allCats.size(); i++) {
            for (int j = i + 1; j < allCats.size(); j++) {
                if (allCats.get(i).equals(allCats.get(j)) || catQueue1.contains(allCats.get(j)) || catQueue2.contains(allCats.get(i)))
                    continue;
                else {
                    catQueue1.add(allCats.get(i));
                    catQueue2.add(allCats.get(j));
                }
            }
        }
        cats.add(catQueue1);
        cats.add(catQueue2);
    }

    @Autowired
    public List<PriorityQueue<Cat>> getQueuesOfCats() {
        return cats;
    }
}
