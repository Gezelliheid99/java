package org.pjj;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.pjj.Utils.MybatisUtils;
import org.pjj.dao.StudentDao;
import org.pjj.domain.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年08月21日 15:36
 */
public class test01 {
    //插入操作测试
    @Test
    public void insert() throws IOException {
        //1.定义mybatis主配置文件的名称
        String config = "mybatis.xml";
        //2.读取这个config表示的文件
        InputStream resourceAsStream = Resources.getResourceAsStream(config);
        //3.创建sqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建sqlSessionFactory对象
        SqlSessionFactory factory = builder.build(resourceAsStream);
        //5.创建sqlSession对象
        SqlSession sqlSession = factory.openSession();
        //6.指定要执行的sql语句的标识
        String sqlId = "org.pjj.dao.studentDao.insertStudent";
        Student student = new Student(1003,"王八","wangba@qq.com",20);
        //7.执行sql语句
        int num = sqlSession.insert(sqlId, student);
        sqlSession.commit();
        //8.输出结果
        System.out.println("insert结果：" + num);
        //9.关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void selectMultiParam(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMulParam(1002, 18);
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void selectIf(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student(null, "张三", null, 0);
        List<Student> students = dao.selectIf(student);
        for (Student stu : students) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void insertTest1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student(1004, "恶灵", "eling@qq.com", 20);
        Student student1 = new Student(1005, "亚索", "yasuo@qq.com", 40);
        Student student2= new Student(1006, "戴安娜", "daianna@qq.com", 99);
        Student student3 = new Student(1007, "锤石", "chuishi@qq.com", 111);
        Student student4 = new Student(1008, "李青", "liqing@qq.com", 30);

        dao.insertLOL(student);
        dao.insertLOL(student1);
        dao.insertLOL(student2);
        dao.insertLOL(student3);
        dao.insertLOL(student4);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectAll(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectAll();
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }


}























