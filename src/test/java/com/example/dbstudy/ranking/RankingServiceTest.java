package com.example.dbstudy.ranking;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class RankingServiceTest {

    @Autowired
    private RankingService rankingService;



    @Test
    @DisplayName("redis를 사용 했을 때 속도 테스트")
    void useRedis(){
        // when
        rankingService.getUserRank("user300");
        // then
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("first");
        Long user400Rank = rankingService.getUserRank("user400");
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        stopWatch.start("second");
        List<String> topRank = rankingService.getTopRank();
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        System.out.println("topRank = " + topRank);
        System.out.println("user400Rank = " + user400Rank);
    }

    @Test
    @DisplayName("redis test")
    void inMemorySortPerformance() {
        // given
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            int score = (int) (Math.random() * 1000000);
            list.add(score);
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // when
        Collections.sort(list);

        // then
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

}