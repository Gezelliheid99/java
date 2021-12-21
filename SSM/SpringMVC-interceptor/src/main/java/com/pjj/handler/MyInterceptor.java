package com.pjj.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author 潘俊杰
 * @date 2021年09月04日 19:04
 */
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String loginName = "";
        Object attr = request.getSession().getAttribute("name");
        if (attr != null) {
            loginName = (String) attr;
        }

        if (!"zs".equals(loginName)){
            request.getRequestDispatcher("tips.jsp").forward(request, response);
            return false;
        }


        return true;
    }


}
