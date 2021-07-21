package com.ramilnagimov.mimimimetr.util;

import com.ramilnagimov.mimimimetr.dao.CatDAO;
import com.ramilnagimov.mimimimetr.entity.Cat;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
@SessionScope
public class LeftAndRightListsUtil {

    private final List<LinkedList<Cat>> cats = new ArrayList<>();
    private final CatDAO catDAO;

    public LeftAndRightListsUtil(CatDAO catDAO) {
        this.catDAO = catDAO;
    }

    @PostConstruct
    public void initMethod() {
        List<Cat> allCats = catDAO.getAllCats();
        Collections.shuffle(allCats);
        LinkedList<Cat> catsLeft = new LinkedList<>();
        LinkedList<Cat> catsRight = new LinkedList<>();
        for (int i = 0; i < allCats.size(); i++) {
            for (int j = i + 1; j < allCats.size(); j++) {
                    catsLeft.add(allCats.get(i));
                    catsRight.add(allCats.get(j));
            }
        }
        cats.add(catsLeft);
        cats.add(catsRight);
    }

    public List<LinkedList<Cat>> getListOfLeftAndRightLists() {
        return cats;
    }
}
