package com.pjj;

import com.pjj.dao.UserDao;
import com.pjj.domain.User;
import com.pjj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年06月07日 22:23
 * 动态sql
 */

//where 和 if 的动态sql
public class MybatisTest04 {
    @Test
    public void selectIfTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);

        User user = new User(4);

        List<User> userList = dao.selectIf(user);
        for (User user1 : userList) {
            System.out.println(user1);
        }
        sqlSession.close();
    }

    @Test

    //list 动态sql
    public void selectForEachTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        List<Integer> id = new ArrayList<>();
        id.add(1);
        id.add(2);
        id.add(3);
        id.add(4);
        List<User> userList = dao.selectForEach(id);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void selectForEachTest2(){
        SqlSession sqlsession = MybatisUtils.getSqlSession();
        UserDao dao = sqlsession.getMapper(UserDao.class);
        List<User> id = new ArrayList<>();
        User user1 = new User(1);
        User user2 = new User(2);
        User user3 = new User(3);
        User user4 = new User(4);
        id.add(user1);
        id.add(user2);
        id.add(user3);
        id.add(user4);

        List<User> userList = dao.selectForEach2(id);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlsession.close();
    }
}
