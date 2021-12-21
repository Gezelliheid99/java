package com.pjj.book.service;

import com.pjj.book.pojo.User;

public interface UserService {
    /**
     * 用户注册
     * @param user
     */
    public void registerUser(User user);

    /**
     * 用户登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return 返回ture表示用户名已存在，false表示可用
     */
    public boolean examUsername(String username);
}
