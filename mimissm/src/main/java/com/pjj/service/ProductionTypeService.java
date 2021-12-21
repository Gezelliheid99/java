package com.pjj.service;

import com.pjj.pojo.ProductType;

import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年09月12日 12:16
 */
public interface ProductionTypeService {

    /**
     * 获取商品类型
     * @return
     */
    List<ProductType> getTypes();
}
