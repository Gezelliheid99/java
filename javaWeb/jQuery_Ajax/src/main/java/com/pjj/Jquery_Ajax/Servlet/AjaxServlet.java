package com.pjj.Jquery_Ajax.Servlet;

import com.google.gson.Gson;
import com.pjj.Jquery_Ajax.pojo.Person;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AjaxServlet extends BaseServlet {

    protected void jQueryAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jQueryAjaxServlet  运行了");
        Person person = new Person(1, "pjj");
        Gson gson = new Gson();
        String personJson = gson.toJson(person);
        response.getWriter().write(personJson);
    }
    protected void jQueryGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jQueryGet  运行了");
        Person person = new Person(1, "pjj");
        Gson gson = new Gson();
        String personJson = gson.toJson(person);
        response.getWriter().write(personJson);
    }
    protected void jQueryPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jQueryPost  运行了");
        Person person = new Person(1, "pjj");
        Gson gson = new Gson();
        String personJson = gson.toJson(person);
        response.getWriter().write(personJson);
    }
    protected void jQueryGetJSON(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jQueryGetJSON  运行了");
        Person person = new Person(1, "pjj");
        Gson gson = new Gson();
        String personJson = gson.toJson(person);
        response.getWriter().write(personJson);
    }
    protected void jQuerySerialize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jQuerySerialize  运行了");
        System.out.println("用户名：" + request.getParameter("username"));
        System.out.println("密码：" + request.getParameter("password"));
        Person person = new Person(1, "pjj");
        Gson gson = new Gson();
        String personJson = gson.toJson(person);
        response.getWriter().write(personJson);
    }




}
