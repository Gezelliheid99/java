package com.pjj.Pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 潘俊杰
 * @date 2021年08月22日 21:13
 */
@Component(value = "myStudent")
public class Student {
    @Value("张三")
    private String name;
    @Value("50")
    private int age;
    @Autowired
    private School school;

    /*用注解注入不需要set方法
    public void setSchool(School school) {
        this.school = school;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
