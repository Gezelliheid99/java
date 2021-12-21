package com.pjj;

import com.pjj.ba01.MyService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 潘俊杰
 * @date 2021年08月24日 13:26
 */
public class MyTest {

    /**
     * 前置通知
     */
    @Test
    public void Test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从容器中获取目标对象
        MyService proxy = (MyService) ac.getBean("Service");
        //用代理对象执行方法
        proxy.doSome("张三", 30);
    }

}
