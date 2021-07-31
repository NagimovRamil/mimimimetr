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
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
public class CatController {

    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/voting")
    public String voting(Model model) {

        List<Cat> cats = catService.fetchNextPairOfCats();
        if (cats.isEmpty())
        {
            List<NameAndImageForViewTopCats> catAndImageForViewTopNames = new LinkedList<>();
            List<Cat> topCats = catService.getTopCats();
            for(Cat cat: topCats) {
                String catBase64 = ImageEncoder.encodeImageToBase64(cat.getImage());
                NameAndImageForViewTopCats newCat = new NameAndImageForViewTopCats(cat.getCatsName(), catBase64);
                catAndImageForViewTopNames.add(newCat);
            }
            model.addAttribute("catList", catAndImageForViewTopNames);
            return "top-cats";
        }

        Cat catLeft = cats.get(0);
        String catLeftBase64 = ImageEncoder.encodeImageToBase64(catLeft.getImage());
        model.addAttribute("catLeft", catLeft);
        model.addAttribute("catLeftBase64", catLeftBase64);

        Cat catRight = cats.get(1);
        String catRightBase64 = ImageEncoder.encodeImageToBase64(catRight.getImage());
        model.addAttribute("catRight", catRight);
        model.addAttribute("catRightBase64", catRightBase64);

        return "/voting";
    }

    @PostMapping ("/voting")
    public void voting(@RequestBody(required=false) Long id ) {
        if(id !=null) catService.updateCatScore(id);
    }
}























