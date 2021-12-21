package com.pjj.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletContext extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1、获取 web.xml 中配置的上下文参数 context-param
        javax.servlet.ServletContext context = getServletConfig().getServletContext();
        String username = context.getInitParameter("username");
        System.out.println("context-param参数username的值为：" + username);
        System.out.println("context-param参数password的值为：" + context.getInitParameter("password"));
//        2、获取当前的工程路径，格式: /工程路径
        System.out.println("当前的工程路径：" + context.getContextPath());
//        3、获取工程部署后在服务器硬盘上的绝对路径
        //其中“/” 的意义为： http://ip:port/工程名/
        System.out.println("工程部署的绝对路径：" + context.getRealPath("/"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
