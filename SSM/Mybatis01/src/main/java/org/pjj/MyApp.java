package org.pjj;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.pjj.Utils.MybatisUtils;
import org.pjj.domain.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年08月20日 16:09
 */
public class MyApp {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //6.指定要执行的sql语句的标识
        String sqlId = "org.pjj.dao.studentDao.selectStudent";
        //7.执行sql语句
        List<Student> studentList = sqlSession.selectList(sqlId);
        //8.输出结果
        studentList.forEach(student -> System.out.println(student));
        //9.关闭sqlSession
        sqlSession.close();

    }
}
