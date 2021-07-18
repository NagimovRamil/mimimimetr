package com.ramilnagimov.mimimimetr.controller;

import com.ramilnagimov.mimimimetr.entity.Cat;
import com.ramilnagimov.mimimimetr.service.CatService;
import com.ramilnagimov.mimimimetr.util.ImageEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {

    private final CatService catService;
//    public ImageDecoder imageDecoder;

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
        String cat1base64 = ImageEncoder.encodeImageToBase64(cat1.getImage());
        Cat cat2 = cats.get(1);
        String cat2base64 = ImageEncoder.encodeImageToBase64(cat2.getImage());
        model.addAttribute("cat1", cat1);
        model.addAttribute("cat2", cat2);
        model.addAttribute("cat1base64", cat1base64);
        model.addAttribute("cat2base64", cat2base64);

        return "voting";
    }

    @PostMapping(value = "/voting", consumes = "application/json", produces = "application/json")
    public void updateCatsScore(@RequestBody int id) {
        catService.updateCatScore(id);
    }
}























