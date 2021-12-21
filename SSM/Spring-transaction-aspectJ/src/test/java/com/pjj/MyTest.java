package com.pjj;

import com.pjj.service.GoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 潘俊杰
 * @date 2021年08月30日 16:01
 */
public class MyTest {
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        GoodsService buyService = (GoodsService) ac.getBean("buyService");
        buyService.buy(1005, 5);
    }
}
