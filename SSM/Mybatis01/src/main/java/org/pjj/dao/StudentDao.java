package org.pjj.dao;

import org.apache.ibatis.annotations.Param;
import org.pjj.domain.Student;

import java.util.List;

public interface StudentDao {
    // 查询student表中所有数据
    public List<Student> selectStudent();

    //插入操作
    public int insertStudent(Student student);

    List<Student> selectMulParam(@Param("id")Integer id,@Param("age") Integer age);

    List<Student> selectIf(Student student);

    int insertLOL(Student student);

    List<Student> selectAll();
}

