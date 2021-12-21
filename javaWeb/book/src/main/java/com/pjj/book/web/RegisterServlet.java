package com.pjj.book.web;

import com.pjj.book.pojo.User;
import com.pjj.book.service.UserService;
import com.pjj.book.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        //2.检查验证码是否正确
        if ("abcd".equalsIgnoreCase(code)){
            //3.检查用户名是否可用
            if (userService.examUsername(username)) {
                //不可用，跳回注册页面
                System.out.println("用户名["+ username +"]已存在！");
                //回显信息
                request.setAttribute("errorMsg","用户名已存在！");
                request.setAttribute("username",username);
                request.setAttribute("email",email);
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            }else {
                //用户名可用，保存到数据库后，跳转到注册成功页面
                userService.registerUser(new User(null,username,password,email));
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
            }
        }else {
            //把回显信息保存在request域中
            request.setAttribute("errorMsg","验证码错误！");
            request.setAttribute("username",username);
            request.setAttribute("email",email);
            //跳回注册页面
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
        }

    }
}
