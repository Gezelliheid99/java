package com.pjj.book.test;

import com.pjj.book.pojo.User;
import com.pjj.book.service.UserService;
import com.pjj.book.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"wangsan","55555","asfg@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"admin","admin",null)));
    }

    @Test
    public void examUsername() {
        if (userService.examUsername("admin")) {
            System.out.println("用户名已存在");
        }else {
            System.out.println("用户名可用");
        }
    }
}