package com.pjj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pjj.dao.ProductInfoDao;
import com.pjj.pojo.ProductInfo;
import com.pjj.pojo.vo.ProductInfoVo;
import com.pjj.service.ProductionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年09月08日 13:54
 */
@Service
public class ProductionInfoServiceImpl implements ProductionInfoService {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public List<ProductInfo> getAll() {
        return productInfoDao.queryAll(new ProductInfo());
    }

    @Override
    public PageInfo splitPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ProductInfo> products = productInfoDao.queryAllOrderDesc("p_id desc");
        // 将对象封装到pageInfo里
        PageInfo<ProductInfo> pageInfo = new PageInfo<>(products);
        return pageInfo;
    }

    @Override
    public int save(ProductInfo productInfo) {
        return productInfoDao.insert(productInfo);
    }

    @Override
    public ProductInfo queryById(Integer id) {
        ProductInfo productInfo = productInfoDao.queryById(id);
        return productInfo;
    }

    /**
     * 更新商品
     * @param info
     * @return
     */
    @Override
    public int update(ProductInfo info) {
        return productInfoDao.update(info);
    }

    /**
     * 删除商品项
     * @param id
     * @return
     */
    @Override
    public int deleteById(Integer id) {
        return productInfoDao.deleteById(id);
    }

    @Override
    public int deleteBatch(String[] ids) {
        return productInfoDao.deleteBatch(ids);
    }

    @Override
    public List<ProductInfo> selectCondition(ProductInfoVo vo) {

        return productInfoDao.selectCondition(vo);
    }

    @Override
    public PageInfo<ProductInfo> splitPageVo(ProductInfoVo vo,int pageSize) {
        PageHelper.startPage(vo.getPage(), pageSize);
        List<ProductInfo> list = productInfoDao.selectCondition(vo);

        return new PageInfo<>(list);
    }
}
