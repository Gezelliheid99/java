package com.pjj.jedis;

import redis.clients.jedis.Jedis;

/**
 * @author 潘俊杰
 * @date 2021年10月01日 15:03
 */
public class Demo {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("192.168.129.128", 6379);
        String ping = jedis.ping();
        System.out.println(ping);
    }
}
