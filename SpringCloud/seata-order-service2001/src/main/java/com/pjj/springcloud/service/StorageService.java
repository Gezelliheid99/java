package com.pjj.springcloud.service;

import com.pjj.springcloud.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 潘俊杰
 * @date 2021年11月14日 15:59
 */
@Component
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    /**
     * 商品id对应库存减少
     * @param productId
     * @param count
     * @return
     */
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId,
                          @RequestParam("count") Integer count);
}
