package com.pjj.dao;


import com.pjj.pojo.Student;

import java.util.List;

/**
 * @author pjj
 */
public interface StudentDao {
    /**
     * 查询所有学生
     * @return
     */
    List<Student> selectStudent();

    int addStudent(Student student);
}
