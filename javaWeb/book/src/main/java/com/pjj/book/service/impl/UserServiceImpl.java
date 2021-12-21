package com.pjj.book.service.impl;

import com.pjj.book.dao.UserDao;
import com.pjj.book.dao.impl.UserDaoImpl;
import com.pjj.book.pojo.User;
import com.pjj.book.service.UserService;

/**
 * @author 潘俊杰
 * @date 2021年07月27日 13:27
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.SaveUser(user);
    }

    @Override
    public User login(User user) {

        return userDao.QueryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean examUsername(String username) {
        if (userDao.QueryUserByUsername(username) == null) {
            //如果等于null，则表示没查到，没有此用户，就可以注册
            return false;
        }
        return true;
    }
}
