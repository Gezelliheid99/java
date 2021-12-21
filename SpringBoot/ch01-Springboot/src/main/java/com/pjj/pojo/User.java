package com.pjj.pojo;

import lombok.Data;

/**
 * @author 潘俊杰
 * @date 2021年09月16日 14:53
 */
@Data
public class User {
    private String name;
    private String sex;

    public User(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
}
