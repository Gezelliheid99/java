package com.pjj.service;

import com.pjj.pojo.Student;

import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年09月03日 10:57
 */
public interface StudentService {
    int addStudent(Student student);

    List<Student> selectStudent();
}
