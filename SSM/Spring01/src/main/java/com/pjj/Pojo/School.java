package com.pjj.Pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.PrivateKey;

/**
 * @author 潘俊杰
 * @date 2021年08月23日 10:59
 */
@Component("mySchool")
public class School {

    @Value("厦门大学")
    private String name;

    @Value("思明区")
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
