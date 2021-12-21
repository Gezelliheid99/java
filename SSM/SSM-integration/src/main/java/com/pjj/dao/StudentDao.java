package com.pjj.dao;
import com.pjj.pojo.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年09月03日 10:39
 */
@Repository("StudentDao")
public interface StudentDao {

    int addStudent(Student student);

    List<Student> selectStudentSsm();
}
