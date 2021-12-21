package com.pjj;

import com.pjj.dao.UserDao;
import com.pjj.domain.User;
import com.pjj.utils.MybatisUtils;
import com.pjj.vo.queryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年06月06日 19:45
 */
public class MybatisTest02 {

    //单个参数
    @Test
    public void selectTest(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao dao = sqlSession.getMapper(UserDao.class);
        //条件为id = 5
        User user = dao.selectById(5);
        System.out.println(user);
        sqlSession.close();
    }


    //多个参数
    @Test
    public void SelectMultiParam(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        List<User> userList = dao.selectMultiParam(5,"詹可薇");
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    //传入对象
    @Test
    public void selectObjectTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        queryParam param = new queryParam();
        param.setParamName("zkw");
        param.setParamRealName("恶灵");
        List<User> userList = dao.selectObjectParam(param);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
