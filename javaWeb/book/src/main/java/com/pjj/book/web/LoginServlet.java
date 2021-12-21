package com.pjj.book.web;

import com.pjj.book.pojo.User;
import com.pjj.book.service.UserService;
import com.pjj.book.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2.调用方法登陆
        User loginUser = userService.login(new User(null, username, password, null));
        //3.根据login()方法返回结果判断登陆是否成功
        if (loginUser == null) {
            request.setAttribute("errorMsg","用户名或密码错误！");
            request.setAttribute("username",username);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }else {
            System.out.println("登陆成功");
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
        }
    }
}
