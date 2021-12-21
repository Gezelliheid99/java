package com.pjj.vo;

/**
 * @author 潘俊杰
 * @date 2021年06月09日 23:08
 */
public class Test {
    public static void main(String[] args) {
        int x = 2;
        int  a = info(x);
        System.out.println(a);
    }

    public static int info(int x){
        if(x <= 1) return x;
        int left = 0;
        int right = x;
        while(left < right){
            long mid = left + ((right - left) >>1);
            long s = mid * mid;
            if(s < x){
                right = (int) (mid - 1);
            }else if (s < x) {
                if ((mid + 1) * (mid + 1) > x) {
                    return (int) mid;
                }
                left = (int) (mid + 1);
            }else {
                return (int) mid;
            }
        }
        return left;
    }
}
