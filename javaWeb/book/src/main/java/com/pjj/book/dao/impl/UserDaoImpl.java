package com.pjj.book.dao.impl;

import com.pjj.book.dao.UserDao;
import com.pjj.book.pojo.User;

/**
 * @author 潘俊杰
 * @date 2021年07月27日 12:22
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User QueryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ?";
        return queryForOne(sql,User.class,username);
    }

    @Override
    public User QueryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ? and password = ?";
        return queryForOne(sql,User.class,username,password);
    }

    @Override
    public int SaveUser(User user) {
        String sql = "insert into t_user(`username`,`password`,`email`) value (?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
