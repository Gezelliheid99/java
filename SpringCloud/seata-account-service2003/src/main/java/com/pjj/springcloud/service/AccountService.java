package com.pjj.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pjj.springcloud.pojo.Account;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author 潘俊杰
 * @date 2021年11月15日 21:09
 */
public interface AccountService extends IService<Account> {

    void decrease(Long userId,BigDecimal money);

}
