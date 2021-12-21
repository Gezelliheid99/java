package com.pjj.controller;

import com.pjj.pojo.Admin;
import com.pjj.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 潘俊杰
 * @date 2021年09月06日 20:16
 */
@Controller
@RequestMapping("/admin")
public class AdminAction {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login.do")
    public String loginAction(String name , String pwd, HttpServletRequest request){
        Admin admin = adminService.login(name, pwd);
        if (admin != null) {
            request.setAttribute("admin", admin);
            return "main";
        }else {
            request.setAttribute("errmsg", "用户名或密码不正确！");
            return "login";
        }






    }
}
