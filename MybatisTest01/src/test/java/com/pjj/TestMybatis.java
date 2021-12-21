package com.pjj;

import com.pjj.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 潘俊杰
 * @date 2021年06月04日 20:19
 */
public class TestMybatis {
    //测试方法
    @Test
    public void TestInsert(){
        //1.定义mybatis主配置文件名称
        String config = "Mybatis.xml";
        SqlSession sqlSession = null;
        try {
            //2.读取mybatis读取的文件
            InputStream is = Resources.getResourceAsStream(config);
            //3.创建sqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //4.创建sqlSessionFactory对象
            SqlSessionFactory factory = builder.build(is);
            //5.获取sqlSession对象
            sqlSession = factory.openSession();
            //6.指定要执行的sql语句的标识。
            String sqlId = "com.pjj.dao.userDao.insertUser";
            //7.执行sql语句，通过sqlId找到语句
            User user = new User();
            user.setId(3);
            user.setLoginName("大胖子");
            user.setLoginpwd("333");
            user.setRealName("大胖子");
            int count = sqlSession.insert(sqlId,user);
            sqlSession.commit();
            //8.输出结果
            System.out.println(count == 1 ? "修改成功！" : "修改失败！");


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //9.关闭sqlSession对象
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
