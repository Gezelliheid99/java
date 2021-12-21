package com.pjj.dao.impl;

import com.pjj.dao.UserDao;
import com.pjj.domain.User;
import com.pjj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年06月06日 10:55
 */
public class UserDaoimpl implements UserDao {

    @Override
    public List<User> selectUsers() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId = "com.pjj.dao.UserDao.selectUsers";
        //执行sql语句，使用sqlSession方法
        List<User> userList = sqlSession.selectList(sqlId);
        //关闭sqlSession
        sqlSession.close();
        return userList;

    }

    @Override
    public int insertUser(User user) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId = "com.pjj.dao.UserDao.insertUser";
        //执行sql语句
        int count = sqlSession.insert(sqlId,user);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
        return count;
    }
}
