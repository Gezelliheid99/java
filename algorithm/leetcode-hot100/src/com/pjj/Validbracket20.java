package com.pjj;

/**
 * @author 潘俊杰
 * @date 2021年11月28日 16:54
 */
public class Validbracket20 {
    public static void main(String[] args) {
        String s = "{[()]";
        boolean valid = isValid(s);
    }
    public static boolean isValid(String s) {
        int len = s.length() / 2;
        for(int i = 0; i < len; i++){
            s = s.replace("()","");
            s = s.replace("{}","");
            s = s.replace("[]","");
        }
        return s.length() == 0;
    }
}
