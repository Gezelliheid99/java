package com.pjj.Utils;

import javax.servlet.http.Cookie;

/**
 * @author 潘俊杰
 * @date 2021年08月13日 15:23
 */
public class CookieUtils {
    /**
     * 查找指定名称的cookie对象
     * @param name
     * @param cookies
     * @return
     */
    public static Cookie findCookie(String name,Cookie[] cookies){
        if (name == null || cookies == null || cookies.length == 0) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
}
