package com.pjj.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pjj.boot.bean.ProductInfo;
import com.pjj.boot.mapper.ProductInfoMapper;
import com.pjj.boot.service.ProductInfoService;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author 潘俊杰
 * @date 2021年09月29日 17:20
 */
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper,ProductInfo> implements ProductInfoService {

}
