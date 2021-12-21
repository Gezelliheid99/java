package com.pjj.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("此网站已废弃，请访问新地址");

//        //设置状态码为302，表示重定向
//        response.setStatus(302);
//        //设置响应头,说明新的地址在哪
//        response.setHeader("location","http://localhost:8080/servlet_war_exploded/response2");

        //第二种方案，推荐使用
        response.sendRedirect("http://localhost:8080/servlet_war_exploded/response2");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
