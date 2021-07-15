package com.ramilnagimov.mimimimetr.controller;

import com.ramilnagimov.mimimimetr.entity.Cat;
import com.ramilnagimov.mimimimetr.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

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

    @RequestMapping("/voting")
    public String voting(Model model) {
//        List<PriorityQueue<Cat>> cats = catService.getListOfCats();
//        Queue<Cat> catQueue1 = cats.get(0);
//        Queue<Cat> catQueue2 = cats.get(1);
//        if (catQueue1.isEmpty() || catQueue2.isEmpty()) {
//            return "top-cats";
//        }
//        Cat cat1 = catQueue1.poll();
//        Cat cat2 = catQueue2.poll();

        List<Cat> cats = catService.getListOfCats();
        if (cats.isEmpty()) {
            return "top-cats";
        }
        Cat cat1 = cats.get(0);
        Cat cat2 = cats.get(1);
        model.addAttribute("cat1", cat1);
        model.addAttribute("cat2", cat2);
        return "voting";

//        List<Cat> allCats = catService.getAllCats();
//        Collections.shuffle(allCats);
//        LinkedList<Cat> catQueue1 = new LinkedList<>();
//        LinkedList<Cat> catQueue2 = new LinkedList<>();
//        for (int i = 0; i < allCats.size(); i++) {
//            for (int j = i+1; j < allCats.size(); j++) {
//                if(allCats.get(i).equals(allCats.get(j))) {
//                    continue;
//                }
//                else {
//                    catQueue1.add(allCats.get(i));
//                    catQueue2.add(allCats.get(j));
//                }
//            }
//        }
//        if (catQueue1.isEmpty() || catQueue2.isEmpty()) {
//            return "top-cats";
//        }
//        Cat cat1 = catQueue1.poll();
//        Cat cat2 = catQueue2.poll();
//        model.addAttribute("cat1", cat1);
//        model.addAttribute("cat2", cat2);
//        return "voting";

    }

//    @RequestMapping("/voting2")
//    public String voting() {
//        return "voting";
//    }

}























