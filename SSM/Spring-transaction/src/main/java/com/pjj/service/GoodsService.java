package com.pjj.service;

import com.pjj.pojo.Goods;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Goods)表服务接口
 *
 * @author makejava
 * @since 2021-08-30 15:04:20
 */

public interface GoodsService {
    void buy(Integer goodsId, Integer nums);
}
