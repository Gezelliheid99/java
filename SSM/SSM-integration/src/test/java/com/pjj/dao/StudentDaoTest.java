package com.pjj.dao;

import com.pjj.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDaoTest {

    @Test
    void addStudent() {
    }

    @Test
    void selectStudentSsm() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        StudentDao dao = (StudentDao) ac.getBean("StudentDao");
        List<Student> students = dao.selectStudentSsm();
        students.forEach(student -> System.out.println(student));
    }
}