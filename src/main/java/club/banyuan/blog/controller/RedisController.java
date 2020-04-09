package club.banyuan.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Controller;

@Controller
public class RedisController {
    @Autowired
    JedisConnectionFactory jedisConnectionFactory;

    void SetInRedis() {
        RedisConnection connection =  jedisConnectionFactory.getConnection();
    }
}
