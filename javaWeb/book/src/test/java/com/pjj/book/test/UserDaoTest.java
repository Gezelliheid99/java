package com.pjj.book.test;

import com.pjj.book.dao.UserDao;
import com.pjj.book.dao.impl.UserDaoImpl;
import com.pjj.book.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {

        if (userDao.QueryUserByUsername("admin") == null) {
            System.out.println("用户名可用！");
        }else {
            System.out.println("用户名已被占用！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.QueryUserByUsernameAndPassword("admin","admin") == null) {
            System.out.println("用户名或密码错误，请重新输入！");
        }else {
            System.out.println("登陆成功！");
        }
    }

    @Test
    public void saveUser() {
        if (userDao.SaveUser(new User(null,"jack","123456","pjj@qq.com")) != -1) {
            System.out.println("保存成功！");
        }
    }
}