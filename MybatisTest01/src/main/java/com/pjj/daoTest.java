package com.pjj;

import com.pjj.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author 潘俊杰
 * @date 2021年06月03日 18:13
 */
public class daoTest {
    public static void main(String[] args) {
        //访问mybatis读取user数据
        //1.定义mybatis主配置文件名称,从target/classes开始找
        String config = "Mybatis.xml";

        SqlSession sqlSession = null;
        try {
            //2.读取mybatis表示的文件
            InputStream is = Resources.getResourceAsStream(config);
            //3.创建sqlsessionFactoryBuilder对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //4.创建SqlsessionFactory对象
            SqlSessionFactory factory = builder.build(is);
            //5.获取Sqlsession对象 【重要】
            sqlSession = factory.openSession();
            //sqlSession = new SqlSessionFactoryBuilder().build(is).openSession();

            //6.指定要执行的sql语句的标识。 sql映射文件中的namespace + "." + 标签的id值 【重要】
            String sqlId = "com.pjj.dao.userDao.selectUsers";
            //7.执行sql语句，通过sqlId找到语句
            List<User> userList = sqlSession.selectList(sqlId);
            //8.输出结果
            for (User user : userList) {
                System.out.println("查询的结果：" + user);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //9.关闭Sqlsession对象
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
