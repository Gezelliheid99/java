package com.pjj.ExceptionHandler;

import com.pjj.exception.AgeException;
import com.pjj.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 潘俊杰
 * @date 2021年09月04日 10:35
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 姓名异常
     * @param exception
     * @return
     */
    @ExceptionHandler(value = NameException.class)
    public ModelAndView doNameException(Exception exception){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "姓名必须是zs，其他用户不能访问");
        mv.addObject("exception", exception);
        mv.setViewName("errorName");
        return mv;
    }

    /**
     * 年龄异常
     * @param exception
     * @return
     */
    @ExceptionHandler(value = AgeException.class)
    public ModelAndView doAgeException(Exception exception){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "年龄不符合要求");
        mv.addObject("exception", exception);
        mv.setViewName("errorAge");
        return mv;
    }

    /**
     * 其他异常
     * @param exception
     * @return
     */
    @ExceptionHandler
    public ModelAndView doException(Exception exception){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "发生其他异常");
        mv.addObject("exception", exception);
        mv.setViewName("defaultError");
        return mv;
    }



}
