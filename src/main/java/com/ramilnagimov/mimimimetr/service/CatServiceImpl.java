package com.ramilnagimov.mimimimetr.service;


import com.ramilnagimov.mimimimetr.dao.CatDAO;
import com.ramilnagimov.mimimimetr.entity.Cat;
import com.ramilnagimov.mimimimetr.util.ListOfPairsOfCatsUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class CatServiceImpl implements CatService {
    private final CatDAO catDAO;
    private final ListOfPairsOfCatsUtil listOfPairsOfCatsUtil;

    public CatServiceImpl(CatDAO catDAO, ListOfPairsOfCatsUtil listOfPairsOfCatsUtil) {
        this.catDAO = catDAO;
        this.listOfPairsOfCatsUtil = listOfPairsOfCatsUtil;
    }

    @Override
    public List<Cat> getTopCats() {
        return catDAO.getTopCats();
    }

    @Override
    public List<Cat> fetchNextPairOfCats() {
        LinkedList<List<Cat>> listOfPairsOfCats =  listOfPairsOfCatsUtil.getListOfPairsOfCats();
        if (listOfPairsOfCats.isEmpty()) {
            return Collections.emptyList();
        }

        return listOfPairsOfCats.pollFirst();
    }

    @Override
    public void updateCatScore(Long id) {
        catDAO.updateCatScore(id);
    }
}
