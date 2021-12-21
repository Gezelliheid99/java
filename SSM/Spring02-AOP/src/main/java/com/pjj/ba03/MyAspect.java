package com.pjj.ba03;

import com.pjj.ba02.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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
    @Around(value = "execution(* *..ba03.*ServiceImpl.doSome(..))")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {

        Object result = null;
        System.out.println("目标方法之前执行" + new Date());
        result = pjp.proceed();
        System.out.println("目标方法之后执行");
        return result;
    }


}


