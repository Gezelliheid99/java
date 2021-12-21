package com.pjj.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.pjj.springcloud.pojo.CommonResult;

/**
 * @author 潘俊杰
 * @date 2021年11月09日 21:15
 */
public class CustomerBlockHandler {
    public static CommonResult CustomerHandler(BlockException exception){
        return new CommonResult(444, "全局异常处理方法----1");
    }
    public static CommonResult CustomerHandler2(BlockException exception){
        return new CommonResult(444, "全局异常处理方法----2");
    }

}
