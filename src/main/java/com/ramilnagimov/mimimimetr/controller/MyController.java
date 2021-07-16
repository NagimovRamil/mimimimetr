package com.ramilnagimov.mimimimetr.controller;

import com.ramilnagimov.mimimimetr.entity.Cat;
import com.ramilnagimov.mimimimetr.service.CatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {

    private final CatService catService;

    public MyController(CatService catService) {
        this.catService = catService;
    }

    @RequestMapping("/top-cats")
    public String showTopCats(Model model) {
        List<Cat> topCats = catService.getTopCats();
        model.addAttribute("topCats", topCats);
        return "top-cats";
    }

    @RequestMapping("/voting")
    public String voting(Model model) {

        List<Cat> cats = catService.getListOfCats();
        if (cats.isEmpty()) {
            List<Cat> topCats = catService.getTopCats();
            model.addAttribute("topCats", topCats);
            return "top-cats";
        }
        Cat cat1 = cats.get(0);
        Cat cat2 = cats.get(1);
        model.addAttribute("cat1", cat1);
        model.addAttribute("cat2", cat2);

        return "voting";
    }

    @PostMapping(value = "/voting", consumes = "application/json", produces = "application/json")
    public void updateCatsScore(@RequestBody int id) {
        catService.updateCatScore(id);
    }
}























