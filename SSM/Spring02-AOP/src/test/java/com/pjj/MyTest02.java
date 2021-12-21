package com.pjj;

import com.pjj.ba02.MyService;
import com.pjj.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 潘俊杰
 * @date 2021年08月24日 15:02
 */
public class MyTest02 {
    /**
     * 后置通知
     */
    @Test
    public void Test02(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyService proxy = (MyService) ac.getBean("Service");
        Student student = proxy.doStudent("张三", 20);
        System.out.println(student);
    }
}
