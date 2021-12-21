package com.pjj;

import com.pjj.dao.UserDao;
import com.pjj.domain.User;
import com.pjj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年06月06日 11:12
 */
public class MybatisTest01 {
    @Test
    public void SelectTest(){

        //使用mybatis动态代理机制，使用SqlSession。getMapper（dao接口）
        //getMapper能够获得dao接口对应的实现类对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        //调用dao方法，实现对数据的操作
        List<User> userList = dao.selectUsers();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void InsertTest(){
        //1.获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setLoginName("恶灵");
        user.setLoginpwd("115515");
        user.setRealName("恶灵");
        int count = dao.insertUser(user);
        sqlSession.commit();
        System.out.println(count == 1 ? "修改成功！" : "修改失败！");
    }

}
