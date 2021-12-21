package com.pjj.springcloud.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pjj.springcloud.dao.PaymentMapper;
import com.pjj.springcloud.pojo.Payment;
import com.pjj.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * @author 潘俊杰
 * @date 2021年10月16日 21:30
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {

}
