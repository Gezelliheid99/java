package com.pjj.controller;

import com.pjj.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 潘俊杰
 * @date 2021年09月01日 17:18
 */
@Controller
public class MyController {

    @RequestMapping(value = "/receive.do")
    public ModelAndView receive (String name,Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", name);
        mv.addObject("age", age);
        mv.setViewName("show");
        return mv;
    }

    @RequestMapping(value = "/receive1.do")
    public ModelAndView receiveObject (Student student){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", student.getName());
        mv.addObject("age", student.getAge());
        mv.setViewName("show");
        return mv;
    }



}
