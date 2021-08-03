package com.ramilnagimov.mimimimetr.util;

import com.ramilnagimov.mimimimetr.dao.CatDAO;
import com.ramilnagimov.mimimimetr.entity.Cat;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
@SessionScope
public class ListOfPairsOfCatsUtil {

    private final LinkedList<List<Cat>> listOfPairsOfCats = new LinkedList<>();
    private final CatDAO catDAO;

    public ListOfPairsOfCatsUtil(CatDAO catDAO) {
        this.catDAO = catDAO;
    }

    @PostConstruct
    public void initMethod() {
        List<Cat> allCats = catDAO.getAllCats();

        for (int i = 0; i < allCats.size(); i++) {
            for (int j = i + 1; j < allCats.size(); j++) {
                ArrayList<Cat> twoCatsList = new ArrayList<>();
                twoCatsList.add(allCats.get(i));
                twoCatsList.add(allCats.get(j));
                listOfPairsOfCats.add(twoCatsList);
            }
        }
        Collections.shuffle(listOfPairsOfCats);
    }

    public LinkedList<List<Cat>> getListOfPairsOfCats() {
        return listOfPairsOfCats;
    }
}
