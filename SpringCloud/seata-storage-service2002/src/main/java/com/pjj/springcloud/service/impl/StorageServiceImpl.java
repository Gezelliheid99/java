package com.pjj.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pjj.springcloud.mapper.StorageMapper;
import com.pjj.springcloud.pojo.Storage;
import com.pjj.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 潘俊杰
 * @date 2021年11月14日 19:05
 */
@Service
@Slf4j
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {
    @Resource
    private StorageMapper mapper;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        mapper.decrease(productId, count);
        log.info("------->storage-service中扣减库存结束");

    }
}
