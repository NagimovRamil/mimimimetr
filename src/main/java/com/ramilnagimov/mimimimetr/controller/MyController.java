package com.ramilnagimov.mimimimetr.controller;

import com.ramilnagimov.mimimimetr.dao.CatDAO;
import com.ramilnagimov.mimimimetr.entity.Cat;
import com.ramilnagimov.mimimimetr.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private CatService catService;

    @RequestMapping("/top-cats")
    public String showTopCats(Model model) {
        List<Cat> topCats = catService.getTopCats();
        model.addAttribute("topCats", topCats);
        return "top-cats";
    }

}























