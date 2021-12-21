package com.pjj.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pjj.springcloud.pojo.Storage;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 潘俊杰
 * @date 2021年11月14日 19:04
 */
public interface StorageService extends IService<Storage> {
    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);
}
