package com.pjj.boot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JUnit5Test {


    @DisplayName("断言机制测试1")
    @Test
    void calTest(){
        int cal = cal(2, 3);
        assertEquals(7, cal);
    }


    int cal (int i,int j){
        return i*j;
    }


}
