package com.pjj.service;

import com.github.pagehelper.PageInfo;
import com.pjj.pojo.ProductInfo;
import com.pjj.pojo.vo.ProductInfoVo;

import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年09月08日 13:53
 */
public interface ProductionInfoService {

    /**
     * 显示全部商品信息(不分页)
     */
    List<ProductInfo> getAll();

    /**
     * 分页
     * @param pageNum 当前页
     * @param pageSize 每页显示数量
     * @return
     */
    PageInfo splitPage(Integer pageNum, Integer pageSize);

    int save(ProductInfo productInfo);

    ProductInfo queryById(Integer id);

    int update(ProductInfo info);

    int deleteById(Integer id);

    int deleteBatch(String[] ids);

    List<ProductInfo> selectCondition(ProductInfoVo vo);

    /**
     * 多条件查询分页
     */
    PageInfo splitPageVo(ProductInfoVo vo, int pageSize);





}










