package com.pjj.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 潘俊杰
 * @date 2021年07月24日 14:24
 */
public class Helloservlet2 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("重写了init初始化方法，做了一些工作");
    }

    /**
     * doGet()方法在get请求时调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get方法");
        ServletConfig servletConfig = getServletConfig();
        System.out.println("servletConfig对象：" +servletConfig);

        //获取初始化param
        System.out.println("初始化参数username的值：" +servletConfig.getInitParameter("username"));
        System.out.println("初始化参数password的值：" +servletConfig.getInitParameter("password"));
    }

    /**
     * doPost()方法在post请求时调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post方法");
    }
}
