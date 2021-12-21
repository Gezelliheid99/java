package com.pjj.service.Impl;

import com.pjj.dao.StudentDao;
import com.pjj.pojo.Student;
import com.pjj.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年09月03日 11:04
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Override
    public int addStudent(Student student) {
        int num = studentDao.addStudent(student);
        return num;
    }

    @Override
    public List<Student> selectStudent() {
        return studentDao.selectStudentSsm();
    }
}
