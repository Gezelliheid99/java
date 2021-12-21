package com.pjj.dao;


import com.pjj.pojo.Student;

import java.util.List;

/**
 * @author pjj
 */
public interface StudentDao {
    List<Student> selectStudent();
}
