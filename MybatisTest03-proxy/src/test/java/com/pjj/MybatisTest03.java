package com.pjj;

import com.pjj.dao.UserDao;
import com.pjj.domain.User;
import com.pjj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年06月07日 14:38
 */
public class MybatisTest03 {
    @Test
    public void selectMapTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);

        List<User> userList = dao.selectAllUsers();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void selectLikeTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);

        String name = "1";
        List<User> userList = dao.selectLike(name);
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
