package com.example.dbstudy.ranking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RankingService {

    private final String RANKING_KEY = "ranking";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public boolean setUserScore(String userId, int score) {
        stringRedisTemplate.opsForZSet().add(RANKING_KEY, userId, score);
        return true;
    }

    public Long getUserRank(String userId) {
        return stringRedisTemplate.opsForZSet().reverseRank(RANKING_KEY, userId);
    }

    public List<String> getTopRank() {
        return new ArrayList<>(Objects.requireNonNull(stringRedisTemplate.opsForZSet().reverseRange(RANKING_KEY, 0, 5)));
    }
}
