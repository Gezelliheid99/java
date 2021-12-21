package com.pjj.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pjj.exception.AgeException;
import com.pjj.exception.MyUserException;
import com.pjj.exception.NameException;
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

    @RequestMapping(value = "/some.do")
    public ModelAndView doSome (String name, Integer age) throws MyUserException {
        ModelAndView mv = new ModelAndView();
        if (!"zs".equals(name)){
            throw new NameException("姓名不正确");
        }
        if (age == null || age >= 80){
            throw new AgeException("年龄不符合规定");
        }

        mv.addObject("name", name);
        mv.addObject("age", age);
        mv.setViewName("show");
        return mv;
    }









}
