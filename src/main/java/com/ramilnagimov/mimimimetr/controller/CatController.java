package com.ramilnagimov.mimimimetr.controller;

import com.ramilnagimov.mimimimetr.entity.Cat;
import com.ramilnagimov.mimimimetr.service.CatService;
import com.ramilnagimov.mimimimetr.util.ImageEncoder;
import com.ramilnagimov.mimimimetr.util.NameAndImageForViewTopCats;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.LinkedList;
import java.util.List;

@Controller
public class CatController {

    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/voting")
    public String showNextPairOfCats(Model model, @RequestBody(required = false) Long id) {

        List<Cat> cats = catService.fetchNextPairOfCats();
        if (cats.isEmpty()) {
            showTopCats(model);
            return "/top-cats";
        }

        Cat catLeft = cats.get(0);
        String catLeftBase64 = ImageEncoder.encodeImageToBase64(catLeft.getImage());
        model.addAttribute("catLeft", catLeft);
        model.addAttribute("catLeftBase64", catLeftBase64);
        model.addAttribute("catLeftID", catLeft.getId());
        model.addAttribute("catLeftName", catLeft.getCatsName());

        Cat catRight = cats.get(1);
        String catRightBase64 = ImageEncoder.encodeImageToBase64(catRight.getImage());
        model.addAttribute("catRight", catRight);
        model.addAttribute("catRightBase64", catRightBase64);
        model.addAttribute("catRightID", catRight.getId());
        model.addAttribute("catRightName", catRight.getCatsName());

        return "/voting";
    }

    public void showTopCats(Model model) {
        List<NameAndImageForViewTopCats> catAndImageForViewTopNames = new LinkedList<>();
        List<Cat> topCats = catService.getTopCats();
        for (Cat cat : topCats) {
            String catBase64 = ImageEncoder.encodeImageToBase64(cat.getImage());
            NameAndImageForViewTopCats newCat = new NameAndImageForViewTopCats(cat.getCatsName(), catBase64);
            catAndImageForViewTopNames.add(newCat);
        }
        model.addAttribute("catList", catAndImageForViewTopNames);
    }

    @PostMapping("/voting")
    public void voting(@RequestBody(required = false) Long id) {
            catService.updateCatScore(id);
    }
}























