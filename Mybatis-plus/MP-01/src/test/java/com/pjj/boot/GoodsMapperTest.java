package com.pjj.boot;

import com.pjj.boot.bean.Goods;
import com.pjj.order.mapper.GoodsMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@Slf4j
@SuppressWarnings("all")
@SpringBootTest
class GoodsMapperTest {

    @Autowired
    private GoodsMapper mapper;

    @Test
    public void ARInsertTest(){
        Goods goods = new Goods();
        goods.setName("高达");
        goods.setAmount(10);
        goods.setPrice(BigDecimal.valueOf(5000.0));
        boolean insert = goods.insert();
        log.info("是否添加成功:" + (insert?"是":"否"));
    }

    @Test
    public void SelectTest(){
        Goods goods = new Goods();
        // goods.setId(3);
        Goods goods1 = goods.selectById();
        System.out.println("查询结果：" + goods1);
    }

    @Test
    public void selectTest(){
        com.pjj.order.entity.Goods goods = mapper.selectById(3);
        System.out.println(goods);
    }

}