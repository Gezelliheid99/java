package com.pjj.boot;

import com.pjj.boot.bean.Goods;
import com.pjj.boot.bean.User;
import com.pjj.boot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@Slf4j
@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void insertTest(){
        User user = new User();
        user.setId(1016);
        user.setName("小煤球");
        user.setEmail("xiaomeiqiu@qq.com");
        user.setAge(5);
        int i = mapper.insertUser(user);
        log.info("添加的行数：" + i);
    }

}