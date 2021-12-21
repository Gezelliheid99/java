package com.pjj.controller;

import com.pjj.pojo.Student;
import com.pjj.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        Integer age = Integer.parseInt(request.getParameter("age"));

        // 创建spring容器对象
        //获取监听器已经创建好的对象
        WebApplicationContext ctx = null;
        ServletContext sc = getServletContext();
        ctx = WebApplicationContextUtils.getWebApplicationContext(sc);

        StudentService studentService = (StudentService) ctx.getBean("studentService");
        Student student = new Student(id, name, email, age);
        studentService.addStudent(student);

        // 给一个页面
        request.getRequestDispatcher("/result.jsp").forward(request, response);

    }
}
