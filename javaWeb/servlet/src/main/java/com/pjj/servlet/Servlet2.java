package com.pjj.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //检查材料
        String username = request.getParameter("username");
        System.out.println("servlet2中查看的参数username：" + username);
        //检查章
        Object seal = request.getAttribute("seal");
        System.out.println("servlet1盖的章子：" + seal);
        //办理业务
        System.out.println("servlet2办理自己的业务");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
