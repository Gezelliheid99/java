package com.pjj;

import com.pjj.Pojo.Student;
import com.pjj.Service.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author 潘俊杰
 * @date 2021年08月22日 19:40
 */
public class MyTest {
    /**
     * spring入门的第一个案例
     */
    @Test
    public void test01(){
        //配置文件路径，在编译后的classes路径下
        String config = "applicationContext.xml";
        //在容器创建的时候，配置文件中的所有对象文件就已经创建好了，对应的接口实现类
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //从容器中获取对象，在容器中已经创建好了
        SomeService someService = (SomeService) ac.getBean("someService");

        someService.doSome();

    }

    /**
     * 获取spring容器中的对象信息
     */
    @Test
    public void test02(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //容器中对象的数量
        int count = ac.getBeanDefinitionCount();
        System.out.println(count);
        //容器中对象的名称
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    /**
     * 一个非自定义的类
     */
    @Test
    public void test03(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Date myDate = (Date) ac.getBean("date");
        System.out.println("现在的时间是：" + myDate);

    }

    /**
     * set注入（设值注入） 较为常用
     */
    @Test
    public void test04(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ac.getBean("student");
        System.out.println(student);
    }

    /**
     * byName byType自动注入
     */
    @Test
    public void test05(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) ac.getBean("student2");
        System.out.println(student);
    }

    /**
     * 注解注入
     */
    @Test
    public void test06(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) ac.getBean("myStudent");
        System.out.println(student);
    }


}
