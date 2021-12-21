package com.pjj.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 潘俊杰
 * @date 2021年07月25日 15:09
 */
public class ServletRequest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        i. getRequestURI() 获取请求的资源路径
        System.out.println("URI资源路径：" + req.getRequestURI());
//        ii. getRequestURL() 获取请求的统一资源定位符（绝对路径）
        System.out.println("URL路径：" + req.getRequestURL());
//        iii. getRemoteHost() 获取客户端的 ip 地址
        System.out.println("客户端IP地址：" + req.getRemoteHost());
//        iv. getHeader() 获取请求头
        System.out.println("请求头：" + req.getHeader("User-Agent"));
//        vii. getMethod() 获取请求的方式 GET 或 POST
        System.out.println("请求的方式：" + req.getMethod());

    }
}
