package com.pjj.service;

import com.pjj.pojo.Student;

import java.util.List;

/**
 * @author pjj
 */
public interface StudentService {
    /**
     * 查询所有学生
     * @return
     */
    List<Student> queryStudent();

    /**
     * 添加学生信息
     * @param student
     * @return
     */
    int addStudent(Student student);
}
