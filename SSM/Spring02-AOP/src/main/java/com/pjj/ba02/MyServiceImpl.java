package com.pjj.ba02;

import org.springframework.stereotype.Service;

/**
 * @author 潘俊杰
 * @date 2021年08月24日 13:02
 * 这个类需要我们去增加切面
 */
@Service("Service")
public class MyServiceImpl implements MyService {
    @Override
    public void doSome(String name, Integer age) {
        System.out.println("目标类执行了");
    }

    @Override
    public Student doStudent(String name, Integer age) {
        System.out.println("目标类执行了");
        Student student = new Student();
        student.setAge(age);
        student.setName(name);
        return student;
    }
}
