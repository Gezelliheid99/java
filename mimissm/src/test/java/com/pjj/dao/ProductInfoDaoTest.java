package com.pjj.dao;

import com.pjj.pojo.ProductInfo;
import com.pjj.pojo.vo.ProductInfoVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_dao.xml","classpath:applicationContext_service.xml"})
public class ProductInfoDaoTest {

    @Autowired
    private ProductInfoDao dao;

    @Test
    public void  selectCondition(){
        ProductInfoVo vo = new ProductInfoVo();
        vo.setPName("5");
        vo.setTypeId(1);
        vo.setLowPrice(1000);
        vo.setHighPrice(3000);
        List<ProductInfo> productInfos = dao.selectCondition(vo);
        productInfos.forEach(info -> System.out.println(info));


    }
}