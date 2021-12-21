package com.pjj.dao;

import com.pjj.domain.User;

import java.util.List;

public interface UserDao {
    //查询表中信息
     List<User> selectUsers();

     int insertUser (User user);
}
