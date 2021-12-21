package com.pjj.boot.controller;

import com.pjj.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 潘俊杰
 * @date 2021年09月16日 21:21
 */
@RestController
public class Controller {
    @Autowired
    private Person person;

    @RequestMapping("/person")
    public Person person(){
        return person;
    }


}
