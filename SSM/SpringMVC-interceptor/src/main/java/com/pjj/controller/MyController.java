package com.pjj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 潘俊杰
 * @date 2021年09月01日 17:18
 */
@Controller
public class MyController {

    @RequestMapping(value = "/some.do")
    public ModelAndView doSome (String name, Integer age) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", name);
        mv.addObject("age", age);
        mv.setViewName("show");
        return mv;
    }









}
