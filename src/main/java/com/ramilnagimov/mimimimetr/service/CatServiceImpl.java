package com.ramilnagimov.mimimimetr.service;


import com.ramilnagimov.mimimimetr.dao.CatDAO;
import com.ramilnagimov.mimimimetr.entity.Cat;
import com.ramilnagimov.mimimimetr.util.CatLinkedListUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CatServiceImpl implements CatService {
    private final CatDAO catDAO;
    private final CatLinkedListUtil catLinkedListUtil;

    public CatServiceImpl(CatLinkedListUtil catLinkedListUtil, CatDAO catDAO) {
        this.catLinkedListUtil = catLinkedListUtil;
        this.catDAO = catDAO;
    }

    @Override
    @Transactional
    public List<Cat> getTopCats() {
        return catDAO.getTopCats();
    }

    @Override
    @Transactional
    public List<Cat> getListOfCats() {
        LinkedList<Cat> catLinkedList1 = catLinkedListUtil.getLinkedListsOfCats().get(0);
        LinkedList<Cat> catLinkedList2 = catLinkedListUtil.getLinkedListsOfCats().get(1);
        if (catLinkedList1.isEmpty() || catLinkedList2.isEmpty()) {
            return Collections.emptyList();
        }
        List<Cat> cats = new ArrayList<>();
        cats.add(catLinkedList1.pollFirst());
        cats.add(catLinkedList2.pollFirst());

        return cats;
    }

    @Override
    @Transactional
    public void updateCatScore(int id) {
        catDAO.updateCatScore(id);
    }
}
