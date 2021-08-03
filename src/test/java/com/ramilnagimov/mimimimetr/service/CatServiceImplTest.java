package com.ramilnagimov.mimimimetr.service;

import com.ramilnagimov.mimimimetr.entity.Cat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CatServiceImplTest {
    @Autowired
    private CatService catService;

    @Test
    void getTopCatsTest() {
        List<Cat> topTenCats = catService.getTopCats();

        assertFalse(topTenCats.isEmpty());
        assertEquals(10, topTenCats.size());
        assertTrue(topTenCats.get(0).getScore() >= topTenCats.get(1).getScore());
    }

    @Test
    void fetchNextPairOfCatsTest() {
        List<Cat> listOfPairOfCats = catService.fetchNextPairOfCats();

        assertEquals(2, listOfPairOfCats.size());
        assertNotEquals(listOfPairOfCats.get(0), listOfPairOfCats.get(1));
        assertEquals(listOfPairOfCats.get(0).getClass(), Cat.class);
        assertEquals(listOfPairOfCats.get(1).getClass(), Cat.class);
    }

    @Test
    void updateCatScoreTest() {
        List<Cat> topTenCatsBeforeUpdate = catService.getTopCats();
        Cat catBeforeUpdate = topTenCatsBeforeUpdate.get(0);
        int scoreBeforeUpdate = catBeforeUpdate.getScore();
        catService.updateCatScore(catBeforeUpdate.getId());
        List<Cat> topTenCatsAfterUpdate = catService.getTopCats();
        Cat catAfterUpdate = topTenCatsAfterUpdate.get(0);
        int scoreAfterUpdate = catAfterUpdate.getScore();

        assertEquals(scoreBeforeUpdate, scoreAfterUpdate - 1);
    }
}