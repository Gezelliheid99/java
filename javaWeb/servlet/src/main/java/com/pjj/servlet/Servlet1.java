package com.pjj.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //检查材料
        String username = request.getParameter("username");
        System.out.println("servlet1中查看的参数username：" + username);
        //盖章
        request.setAttribute("seal","柜台1盖的章");
        //问路
        //路径为servlet2在web.xml中配置的路径
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servlet2");
        //前进
        requestDispatcher.forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
