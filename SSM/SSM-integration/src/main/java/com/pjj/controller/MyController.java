package com.pjj.controller;

import com.pjj.pojo.Student;
import com.pjj.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年09月03日 11:20
 */
@Controller
@RequestMapping("/student")
public class MyController {
    @Resource
    private StudentService service;

    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student){
        ModelAndView mv = new ModelAndView();
        String tips = "注册失败";
        int num = service.addStudent(student);
        if (num > 0 ){
            tips = "学生【" + student.getName() + "】注册成功";
        }
        mv.addObject("tips", tips);
        mv.setViewName("result");
        return mv;
    }
    @RequestMapping("/listStudent.do")
    @ResponseBody
    public List<Student> queryStudent(){
        List<Student> students = service.selectStudent();
        return students;
    }

}
