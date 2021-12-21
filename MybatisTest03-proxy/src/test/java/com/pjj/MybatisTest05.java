package com.pjj;

import com.github.pagehelper.PageHelper;
import com.pjj.dao.UserDao;
import com.pjj.domain.User;
import com.pjj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年06月08日 16:25
 */
public class MybatisTest05 {

    @Test
    public void selectAllPageHelperTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        PageHelper.startPage(1,3);
        List<User> userList = dao.selectUsers();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();

    }
}
