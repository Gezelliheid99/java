package com.pjj.springcloud.controller;

import com.pjj.springcloud.pojo.CommonResult;
import com.pjj.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author 潘俊杰
 * @date 2021年11月15日 21:20
 */
@RestController
public class AccountController {
    @Resource
    private AccountService service;

    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId,
                                 @RequestParam("money") BigDecimal money){
        service.decrease(userId, money);
        return new CommonResult(200, "账户" + userId + "扣款" + money + "元成功");
    }
}
