package com.pjj.service.impl;

import com.pjj.dao.ProductTypeDao;
import com.pjj.pojo.ProductType;
import com.pjj.service.ProductionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年09月12日 12:17
 */
@Service("ProductionTypeServiceImpl")
public class ProductionTypeServiceImpl implements ProductionTypeService {

    @Autowired
    private ProductTypeDao dao;

    @Override
    public List<ProductType> getTypes() {
        return dao.queryAll(new ProductType());
    }
}
