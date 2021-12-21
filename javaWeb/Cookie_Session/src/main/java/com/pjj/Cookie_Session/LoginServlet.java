package com.pjj.Cookie_Session;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("admin".equals(username) && "admin".equals(password)){
            // 登陆成功
            Cookie usernameCookie = new Cookie("username",username);
            Cookie passwordCookie = new Cookie("password",password);
            usernameCookie.setMaxAge(60 * 60 * 24 * 7);  //保留7天
            passwordCookie.setMaxAge(60 * 60 * 24 * 7);  //保留7天
            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);
            System.out.println("登录成功");
        }else{
            // 登陆失败
            System.out.println("登录失败");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
