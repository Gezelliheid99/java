package com.pjj.book.dao;

import com.pjj.book.pojo.User;

public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User QueryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    public User QueryUserByUsernameAndPassword(String username,String password);

    /**
     * 保存用户信息
     * @return 返回-1说明保存失败
     */
    public int SaveUser(User user);


}
