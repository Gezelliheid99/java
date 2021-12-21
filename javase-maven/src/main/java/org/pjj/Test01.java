package org.pjj;

/**
 * @author 潘俊杰
 * @date 2021年06月02日 21:03
 */
public class Test01 {
    public static void main(String[] args) {
        Test01 test01 = new Test01();
        int result = test01.add(10,20);
        System.out.println(result);
    }


    public int add(int a,int b){
        return a + b;
    }
}
