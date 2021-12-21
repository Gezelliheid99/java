package com.pjj.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author 潘俊杰
 * @date 2021年07月24日 12:17
 */
public class Helloservlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //1.可以获取servlet程序的servlet-name的别名
        System.out.println("servlet的别名是：" +servletConfig.getServletName());
        //2.获取初始化参数init-param
        System.out.println("初始化参数username的值：" +servletConfig.getInitParameter("username"));
        System.out.println("初始化参数password的值：" +servletConfig.getInitParameter("password"));
        //3.获取ServletContext对象
        System.out.println("ServletContext对象：" +servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    /**
     * service方法是用来专门处理请求和相应的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(javax.servlet.ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello servlet 被访问了");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        if ("GET".equals(method)){
            System.out.println("get请求");
        }else {
            System.out.println("post请求");
        }


    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
