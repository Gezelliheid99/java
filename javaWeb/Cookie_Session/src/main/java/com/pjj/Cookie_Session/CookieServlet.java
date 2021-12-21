package com.pjj.Cookie_Session;

import com.pjj.Utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {

    protected void createCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建Cookie对象
        Cookie cookie = new Cookie("key1", "value1");
        //通知客户端保存Cookie
        response.addCookie(cookie);

        response.getWriter().write("Cookie创建成功！");
    }

    protected void getCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            response.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + " ] <br>");
        }
        //查找指定cookie
        Cookie neededCookie = CookieUtils.findCookie("key1",cookies);
        response.getWriter().write("所需要的cookie为[" + neededCookie.getName() + "=" + neededCookie.getValue() + " ]" );
    }

    protected void updateCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //找到需要修改的cookie
        Cookie cookie = CookieUtils.findCookie("key1", request.getCookies());
        //设置新的值
        if (cookie != null) {
            cookie.setValue("newValue");
            //传入客户端
            response.addCookie(cookie);
            response.getWriter().write(cookie.getName() + "的值修改成功！");
        }



    }

    protected void deleteNow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = CookieUtils.findCookie("key1", request.getCookies());
        if (cookie != null) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

    }
}
