package com.pjj.boot.service.impl;

import com.pjj.boot.bean.Goods;

import com.pjj.boot.mapper.GoodsMapper;
import com.pjj.boot.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 潘俊杰
 * @date 2021年09月29日 15:29
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper mapper;

    /**
     * 添加商品
     * @param goods
     * @return
     */
    @Override
    public int insertGoods(Goods goods){
        return mapper.insert(goods);
    }

    @Override
    public Goods selectGoodsById(Integer id){
        return mapper.selectGoods(id);
    }

    @Override
    public void insertGood(Goods goods){
        mapper.insertGoods(goods);
    }
}
