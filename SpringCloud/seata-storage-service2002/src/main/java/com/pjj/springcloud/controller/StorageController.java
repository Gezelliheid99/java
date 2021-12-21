package com.pjj.springcloud.controller;

import com.pjj.springcloud.pojo.CommonResult;
import com.pjj.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 潘俊杰
 * @date 2021年11月14日 19:30
 */
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    @RequestMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId,
                          @RequestParam("count") Integer count){
        storageService.decrease(productId, count);
        return new CommonResult(200, "库存商品id"+productId+"扣减"+count+"成功");
    }
}
