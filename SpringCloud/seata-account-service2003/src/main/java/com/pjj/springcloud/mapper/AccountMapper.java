package com.pjj.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pjj.springcloud.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author 潘俊杰
 * @date 2021年11月15日 21:09
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
    /**
     * 扣款
     * @param userId
     * @param money
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
