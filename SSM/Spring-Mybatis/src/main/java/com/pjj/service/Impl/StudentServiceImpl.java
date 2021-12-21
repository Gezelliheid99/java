package com.pjj.service.Impl;

import com.pjj.dao.StudentDao;
import com.pjj.pojo.Student;
import com.pjj.service.StudentService;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年08月26日 8:22
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao ;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> queryStudent() {
        List<Student> students = studentDao.selectStudent();
        return students;
    }
}
