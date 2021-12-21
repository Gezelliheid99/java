package com.pjj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 潘俊杰
 * @date 2021年09月01日 8:34
 */
@Controller
public class MyController {

    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "执行dosome方法");
        // mv.setViewName("/WEB-INF/view/show.jsp");
        // 配置了视图路径后
        mv.setViewName("show");
        return mv;
    }

    /**
     * 指定method为post
     * @return
     */
    @RequestMapping(value = "/other.do",method = RequestMethod.GET)
    public ModelAndView doOther(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "执行doOther方法");
        mv.setViewName("other");
        return mv;
    }

    /**
     * 转发操作
     * @return
     */
    @RequestMapping(value = "/forward.do")
    public ModelAndView doForward(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "执行doForward方法");
        mv.setViewName("forward:/hello.jsp");
        return mv;
    }

}
