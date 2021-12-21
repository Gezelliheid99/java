package com.pjj.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//        //设置服务器字符集
//        response.setCharacterEncoding("UTF-8");
//        //通过响应头设置浏览器的字符集也为UTF-8
//        response.setHeader("Content-Type","text/html;charset=UTF-8");

        //方案2，同时设置了服务器和客户端的字符集，还设置了响应头
        //此方法一定要在获取流对象之前调用才有效
        response.setContentType("text/html;charset=UTF-8");



        PrintWriter writer = response.getWriter();
        writer.println("服务器响应的内容");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
