package com.pjj;

import com.pjj.pojo.Pet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author 潘俊杰
 * @date 2021年09月15日 15:45
 * 主程序
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        // Pet pet = run.getBean(Pet.class);
        // System.out.println("宠物：" + pet);

        boolean pet = run.containsBean("pet");
        System.out.println("是否有pet：" + pet);

        System.out.println("是否有userzs：" + run.containsBean("userzs"));
    }
}
