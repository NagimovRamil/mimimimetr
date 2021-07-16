package com.ramilnagimov.mimimimetr.util;

import com.ramilnagimov.mimimimetr.dao.CatDAO;
import com.ramilnagimov.mimimimetr.entity.Cat;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
@SessionScope
public class CatLinkedListUtil {

    private final List<LinkedList<Cat>> cats = new ArrayList<LinkedList<Cat>>();
    private final CatDAO catDAO;

    public CatLinkedListUtil(CatDAO catDAO) {
        this.catDAO = catDAO;
    }

    @PostConstruct
    public void initMethod() {
        List<Cat> allCats = catDAO.getAllCats();
        Collections.shuffle(allCats);
        LinkedList<Cat> catLinkedList1 = new LinkedList<>();
        LinkedList<Cat> catLinkedList2 = new LinkedList<>();
        for (int i = 0; i < allCats.size(); i++) {
            for (int j = i + 1; j < allCats.size(); j++) {
                    catLinkedList1.add(allCats.get(i));
                    catLinkedList2.add(allCats.get(j));
            }
        }
        cats.add(catLinkedList1);
        cats.add(catLinkedList2);
    }

    public List<LinkedList<Cat>> getLinkedListsOfCats() {
        return cats;
    }
}
