package com.pjj;

import com.pjj.dao.UserDao;
import com.pjj.dao.impl.UserDaoimpl;
import com.pjj.domain.User;
import org.junit.Test;

import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年06月06日 11:12
 */
public class MybatisTest01 {

    @Test
    public void selectUsers(){
        UserDao dao = new UserDaoimpl();
        List<User> userList = dao.selectUsers();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void insertTest(){
        User user = new User();
        user.setLoginName("李四");
        user.setLoginpwd("354");
        user.setRealName("李四");
        UserDao dao = new UserDaoimpl();
        int count = dao.insertUser(user);
        System.out.println("修改的数据数量为：" + count);
    }
}
