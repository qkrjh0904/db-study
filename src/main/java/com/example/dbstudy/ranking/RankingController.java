package com.example.dbstudy.ranking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RankingController {

    @Autowired
    private RankingService rankingService;

    @GetMapping("/setUserScore/{userId}/{score}")
    public void setRanking(@PathVariable String userId, @PathVariable Integer score) {
        rankingService.setUserScore(userId, score);
    }

    @GetMapping("/getUserRank/{userId}")
    public Long getRanking(@PathVariable String userId) {
        return rankingService.getUserRank(userId);
    }

    @GetMapping("/getTopRank")
    public List<String> getTopRank() {
        return rankingService.getTopRank();
    }

}

