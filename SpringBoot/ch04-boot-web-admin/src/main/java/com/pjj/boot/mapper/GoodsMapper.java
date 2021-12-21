package com.pjj.boot.mapper;

import com.pjj.boot.bean.Goods;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 潘俊杰
 * @date 2021年09月29日 15:25
 */

public interface GoodsMapper {
    /**
     * 添加商品
     * @param goods
     */
    int insert(Goods goods);

    Goods selectGoods(Integer id);

    void insertGoods(Goods goods);
}
