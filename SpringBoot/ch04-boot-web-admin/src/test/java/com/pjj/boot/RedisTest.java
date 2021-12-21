package com.pjj.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SuppressWarnings("all")
@SpringBootTest
class RedisTest {

    // @Autowired
    // StringRedisTemplate template;
    //
    // @Autowired
    // private RedisConnectionFactory factory;
    //
    // @Test
    // public void redisTest(){
    //     ValueOperations<String, String> operations = template.opsForValue();
    //     // operations.set("hello", "word");
    //     String hello = operations.get("hello");
    //     System.out.println(hello);
    //     System.out.println(factory.getClass());
    //
    // }


}
