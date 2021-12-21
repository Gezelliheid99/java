package com.pjj.dao;



import com.pjj.domain.User;

import java.util.List;

//借口操作user表
public interface userDao {
    //查询所有用户表信息
    public List<User> selectUsers();

    //插入信息
    public int insertUser(User user);
}
