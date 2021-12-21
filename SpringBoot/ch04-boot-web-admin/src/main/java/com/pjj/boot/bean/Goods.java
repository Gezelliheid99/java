package com.pjj.boot.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 潘俊杰
 * @date 2021年09月29日 15:26
 */
@Data
public class Goods {
    private Long id;
    private String name;
    private Integer amount;
    private BigDecimal price;
}
