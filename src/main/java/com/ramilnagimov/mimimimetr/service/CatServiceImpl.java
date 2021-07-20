package com.ramilnagimov.mimimimetr.service;


import com.ramilnagimov.mimimimetr.dao.CatDAO;
import com.ramilnagimov.mimimimetr.entity.Cat;
import com.ramilnagimov.mimimimetr.util.LeftAndRightListsUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class CatServiceImpl implements CatService {
    private final CatDAO catDAO;
    private final LeftAndRightListsUtil leftAndRightListsUtil;

    public CatServiceImpl(LeftAndRightListsUtil leftAndRightListsUtil, CatDAO catDAO) {
        this.leftAndRightListsUtil = leftAndRightListsUtil;
        this.catDAO = catDAO;
    }

    @Override
    public List<Cat> getTopCats() {
        return catDAO.getTopCats();
    }

    @Override
    public List<Cat> fetchNextPairOfCats() {
        LinkedList<Cat> leftCatsList = leftAndRightListsUtil.getListOfLeftAndRightLists().get(0);
        LinkedList<Cat> rightCatsList = leftAndRightListsUtil.getListOfLeftAndRightLists().get(1);
        if (leftCatsList.isEmpty() || rightCatsList.isEmpty()) {
            return Collections.emptyList();
        }
        List<Cat> cats = new ArrayList<>();
        cats.add(leftCatsList.pollFirst());
        cats.add(rightCatsList.pollFirst());

        return cats;
    }

    @Override
    public void updateCatScore(Long id) {
        catDAO.updateCatScore(id);
    }
}
