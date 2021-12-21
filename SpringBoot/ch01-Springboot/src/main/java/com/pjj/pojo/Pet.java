package com.pjj.pojo;

import lombok.Data;

/**
 * @author 潘俊杰
 * @date 2021年09月15日 17:33
 */
@Data
public class Pet {
    private String name;
    private Integer age;

    public Pet(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
