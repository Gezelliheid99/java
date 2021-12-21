package com.pjj.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import javax.swing.*;
import java.util.Set;


/**
 * @author 潘俊杰
 * @date 2021年10月01日 15:53
 */
public class JedisTest {


    @Test
    public void demo1(){
        Jedis jedis = new Jedis("192.168.129.128", 6379);
        jedis.set("name", "pjj");
        String name = jedis.get("name");
        System.out.println(name);


        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
        jedis.close();
    }
}
