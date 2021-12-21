package com.pjj.boot.service;

import com.pjj.boot.bean.Goods;

/**
 * @author 潘俊杰
 * @date 2021年09月29日 17:22
 */
public interface GoodsService {
    int insertGoods(Goods goods);

    Goods selectGoodsById(Integer id);

    void insertGood(Goods goods);
}
