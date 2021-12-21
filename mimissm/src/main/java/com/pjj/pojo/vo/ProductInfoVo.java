package com.pjj.pojo.vo;

import lombok.Data;

/**
 * @author 潘俊杰
 * @date 2021年09月14日 10:55
 */
@Data
public class ProductInfoVo {
    private String pName;
    private Integer typeId;
    private Integer lowPrice;
    private Integer highPrice;
    private Integer page=1;


}
