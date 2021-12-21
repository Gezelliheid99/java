package com.pjj.utils;

/**
 * @author 潘俊杰
 * @date 2021年10月07日 14:34
 */
public class SleepUtils {
    public static void sleep(int second){
        try {
            Thread.sleep(1000*second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
