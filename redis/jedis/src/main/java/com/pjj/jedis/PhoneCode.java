package com.pjj.jedis;

import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author 潘俊杰
 * @date 2021年10月01日 16:22
 */
public class PhoneCode {
    public static void main(String[] args) {
        verifyCode("123456");
        // getRedisCode("123456", "152595");

    }

    public static int getCode(){
        Random random = new Random();
        int i = random.nextInt(1000000);
        return i;
    }

    /**
     * 校验手机号发送次数，和验证码过期时间
     * @param phoneNumber
     */
    public static void verifyCode(String phoneNumber){
        Jedis jedis = new Jedis("192.168.129.128", 6379);
        String countKey = "verifyCode"+phoneNumber+":count";
        String codeKey = "verifyCode"+phoneNumber+":code";
        String count = jedis.get(countKey);
        Date current = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String newDate = df.format(new Date(current.getTime() + 24 * 60 * 60 * 1000));
        if (count == null) {
            jedis.setex(countKey, 24*60*60, "1");
        }else if(Integer.parseInt(count) <= 2){
            jedis.incr(countKey);
        }else if (Integer.parseInt(count) > 2){
            System.out.println("今天发送次数以达三次，请于"+newDate+"后再尝试");
            jedis.close();
            return;
        }

        String vCode = String.valueOf(getCode());
        jedis.setex(codeKey, 120, vCode);
        jedis.close();
    }

    /**
     * 校验验证码
     * @param phoneNumber
     * @param code
     */
    public static void getRedisCode(String phoneNumber,String code){
        Jedis jedis = new Jedis("192.168.129.128", 6379);
        String codeKey = "verifyCode"+phoneNumber+":code";
        String s = jedis.get(codeKey);
        if (code != null && code.equals(s)){
            System.out.println("验证码正确");
        }else {
            System.out.println("验证码错误或已过期");
        }
        jedis.close();
    }
}
