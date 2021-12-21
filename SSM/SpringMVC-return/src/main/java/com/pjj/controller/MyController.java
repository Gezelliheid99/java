package com.pjj.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pjj.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 潘俊杰
 * @date 2021年09月01日 17:18
 */
@Controller
public class MyController {

    @RequestMapping(value = "/receive.do")
    public String receive (String name,Integer age){
        return "show";
    }

    @RequestMapping(value = "/returnVoid-ajax.do")
    public void doAjax (HttpServletResponse response,String name, Integer age) throws IOException {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        String json = "";
        if (student != null) {
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(student);
            System.out.println("student转换到的对象" + json);
        }
        // 输出数据，响应ajax的请求
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(json);
        writer.flush();
        writer.close();
    }

    @RequestMapping(value = "/returnJson.do")
    @ResponseBody
    public Object dreturnJson (String name, Integer age){
        Student student = new Student();
        student.setName("张三");
        student.setAge(20);
        return student;
    }









}
