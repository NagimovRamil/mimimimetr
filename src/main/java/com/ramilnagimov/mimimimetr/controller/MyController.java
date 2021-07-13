package com.ramilnagimov.mimimimetr.controller;

import com.ramilnagimov.mimimimetr.dao.CatDAO;
import com.ramilnagimov.mimimimetr.entity.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private CatDAO catDAO;

    @RequestMapping("/all-cats")
    public String showAllCats(@RequestParam(name="all-cats", required=false, defaultValue="cats") String name, Model model) {

        List<Cat> allCats = catDAO.getAllCats();
        model.addAttribute("allCats", allCats);

        return "all-cats";
    }

}























