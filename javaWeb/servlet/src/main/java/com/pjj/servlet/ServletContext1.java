package com.pjj.servlet;

import javax.servlet.*;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
import java.io.IOException;


/**
 * ServletContext可以像map一样操作键值对
 */
public class ServletContext1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        context.setAttribute("key1","value1");
        System.out.println("获取key1的值：" + context.getAttribute("key1"));
    }





}
