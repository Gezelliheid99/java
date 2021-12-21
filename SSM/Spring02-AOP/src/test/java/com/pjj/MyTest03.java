package com.pjj;

import com.pjj.ba03.MyService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 潘俊杰
 * @date 2021年08月24日 15:59
 */
public class MyTest03 {

    @Test
    public void Test03(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyService proxy = (MyService) ac.getBean("Service");
        proxy.doSome("李飞", 20);
    }
}
