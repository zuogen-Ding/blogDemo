package club.banyuan.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

  
    public void storeToken(String k, String v, Integer sec) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(k, v, sec, TimeUnit.SECONDS);
    }

    public String getUsernameByToken(String token) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(token);
    }
}
