package com.ramilnagimov.mimimimetr.service;


import com.ramilnagimov.mimimimetr.dao.CatDAO;
import com.ramilnagimov.mimimimetr.entity.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CatServiceImpl implements CatService {
    @Autowired
    private CatDAO catDAO;

    @Override
    @Transactional
    public List<Cat> getTopCats() {
        return catDAO.getTopCats();
    }

}
