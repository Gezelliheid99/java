package com.pjj.ba02;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 潘俊杰
 * @date 2021年08月24日 13:03
 * @aspect 表示是切面类，存放切面功能的类
 */
@Aspect
@Component("MyAspect")
public class MyAspect {

    /**
     * @AfterReturning 后置通知
     */
    @AfterReturning(value = "execution(* *..ba02.*ServiceImpl.doSome(..))",
                    returning = "result")
    public void myAfter(Object result){
        System.out.println("后置通知执行了" + result);
    }

    @AfterReturning(value = "execution(* *..ba02.*ServiceImpl.doStudent(..))",
            returning = "result")
    public void myAfter2(Object result){
        System.out.println("后置通知执行了" + result);
        Student student = (Student) result;
        student.setName("王八");
        student.setAge(80);
        result = student;
        System.out.println("修改后的student" + result);

    }


}
