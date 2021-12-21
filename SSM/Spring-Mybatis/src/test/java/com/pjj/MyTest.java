package com.pjj;

import com.pjj.dao.StudentDao;
import com.pjj.pojo.Student;
import com.pjj.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年08月26日 8:54
 */
public class MyTest {

    @Test
    public void Test01(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name + "||" + ac.getBean( name));
        }
    }

    @Test
    public void Test02(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        StudentDao studentDao = (StudentDao) ac.getBean("studentDao");
        List<Student> students = studentDao.selectStudent();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void Test03(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        StudentService studentService = (StudentService) ac.getBean("studentService");
        List<Student> students = studentService.queryStudent();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
