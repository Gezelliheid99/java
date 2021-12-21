package com.pjj.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pjj.springcloud.mapper.AccountMapper;
import com.pjj.springcloud.pojo.Account;
import com.pjj.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author 潘俊杰
 * @date 2021年11月15日 21:18
 */
@Service
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
    @Resource
    private AccountMapper mapper;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("====>2003对账户扣款开始");
        // try {
        //     Thread.sleep(20000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        mapper.decrease(userId, money);
        log.info("====>2003对账户扣款完成");
    }
}
