package com.pjj.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 潘俊杰
 * @date 2021年06月04日 21:01
 */
public class MybatisUtils {
    //需要在方法体内调用factory，若在静态代码块中的话是局部变量，没办法调用
    private static SqlSessionFactory factory = null;

    //只创建一个SqlSessionFactory对象
    //使用static代码块
    static{
        String config = "Mybatis.xml";
        //读取mybatis表示的文件
        try {
            InputStream is = Resources.getResourceAsStream(config);
            //创建SqlSessionFactory对象
            factory = new SqlSessionFactoryBuilder().build(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //获取SqlSession的方法
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        if (factory != null) {
            sqlSession = factory.openSession(); //非自动提交事务
        }return sqlSession;
    }
}
