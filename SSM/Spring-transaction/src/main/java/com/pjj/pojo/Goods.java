package com.pjj.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * (Goods)实体类
 *
 * @author makejava
 * @since 2021-08-30 15:04:20
 */
@Data
public class Goods implements Serializable {
    private static final long serialVersionUID = 904482040737405387L;

    private Integer id;
    private String name;
    private Integer amount;
    private Double price;


}
