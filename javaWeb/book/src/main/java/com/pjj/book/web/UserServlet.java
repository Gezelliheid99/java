package com.pjj.book.web;

import com.google.gson.Gson;
import com.pjj.book.pojo.User;
import com.pjj.book.service.UserService;
import com.pjj.book.service.impl.UserServiceImpl;
import com.pjj.book.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();


    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
            request.getSession().setAttribute("user",loginUser);
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //销毁Session中保存的账户信息
        request.getSession().invalidate();
        //重定向到首页
        response.sendRedirect(request.getContextPath());
    }

    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //获取验证码
        String googleCode = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除客户端的验证码信息
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //1.获取请求的参数
        String code = request.getParameter("code");
        User user = WebUtils.copyParameterToBean(request.getParameterMap(),new User());
        //2.检查验证码是否正确
        if (googleCode != null && googleCode.equalsIgnoreCase(code)){
            //3.检查用户名是否可用
            if (userService.examUsername(user.getUsername())) {
                //不可用，跳回注册页面
                //回显信息
                request.setAttribute("errorUsername","用户名已存在！");
                request.setAttribute("username",user.getUsername());
                request.setAttribute("email",user.getEmail());
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            }else {
                //用户名可用，保存到数据库后，跳转到注册成功页面
                userService.registerUser(user);
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
            }
        }else {
            //把回显信息保存在request域中
            request.setAttribute("errorCode","验证码错误！");
            request.setAttribute("username",user.getUsername());
            request.setAttribute("email",user.getEmail());
            //跳回注册页面
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
        }
    }

    protected void ajaxExistUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 获取请求的参数
        String username = request.getParameter("username");
        // 调用userService.examUsername()
        boolean examUsername = userService.examUsername(username);
        // 把返回的结果封装成map对象
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("examUsername", examUsername);
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        response.getWriter().write(json);
    }

}
