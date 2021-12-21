package com.pjj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 潘俊杰
 * @date 2021年11月28日 17:48
 */
public class JustOnceNum136 {
    public static void main(String[] args) {
        int i = singleNumber(new int[]{2, 2, 1,3,4,5,5,4});
        System.out.println(i);
    }
    public static int singleNumber(int[] nums) {
        int n = 0;
        for (int i : nums){
            n = n^i;
        }
        return n;
    }
}
