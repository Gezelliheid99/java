package com.pjj.Cookie_Session;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionServlet extends BaseServlet {

    protected void create_getSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //第一次为创建，如果已经创建好了则直接获取
        HttpSession session = request.getSession();
        //判断是否是新创建的session
        boolean sessionNew = session.isNew();
        response.getWriter().write(sessionNew==true?"此Session是新创建的 <br>":"此Session不是新创建的 <br>");
        //获取session的唯一id
        String sessionId = session.getId();
        response.getWriter().write("Session的id是" + sessionId + "<br>");
    }

    protected void setAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("key1","value1");
        response.getWriter().write("已经往Session中保存了数据");
    }

    protected void getAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object attribute = request.getSession().getAttribute("key1");
        response.getWriter().write("从Session中取出的数据是：" + attribute);
    }

    protected void defaultLife(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maxInactiveInterval = request.getSession().getMaxInactiveInterval();
        response.getWriter().write("Session的默认存活时长为" + maxInactiveInterval + "秒");
    }
    protected void lifeTime3sec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setMaxInactiveInterval(3);
        response.getWriter().write("Session超时时长已被设置为3s");
    }
    protected void destroyNow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.getWriter().write("Session即将马上销毁");
    }





}
