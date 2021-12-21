package com.pjj.pojo;

import lombok.Data;

/**
 * @author 潘俊杰
 * @date 2021年08月20日 15:33
 */
@Data
public class Student {
    private Integer id;
    private String name;
    private String email;
    private Integer age;

    public Student(Integer id, String name, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
