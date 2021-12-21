package org.pjj.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 潘俊杰
 * @date 2021年08月21日 15:54
 */
public class MybatisUtils {

    private static SqlSessionFactory factory = null;

    static {
        String config = "mybatis.xml";
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream(config);
            factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取sqlSession
     public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
         if (factory != null) {
             sqlSession = factory.openSession();
         }
         return sqlSession;
     }
}
