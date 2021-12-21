package com.pjj.ba01;

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
     * 必须是public void 开头,参数不是自定义的
     */
    @Before("execution(public void com.pjj.ba01.MyServiceImpl.doSome(String,Integer))")
    public void doBefore(){
        System.out.println("前置通知切面功能：在目标方法之前输出时间" + new Date());
    }
}
