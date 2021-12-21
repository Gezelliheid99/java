package com.pjj.dao;

import com.pjj.pojo.Goods;
import org.springframework.stereotype.Repository;

/**
 * @author 潘俊杰
 * @date 2021年08月30日 15:20
 */
@Repository("goodsDao")
public interface GoodsDao {
    int updateGoods(Goods goods);

    Goods selectGoodsById(Integer id);
}
