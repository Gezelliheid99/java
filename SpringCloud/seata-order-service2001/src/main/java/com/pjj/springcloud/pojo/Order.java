package com.pjj.springcloud.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author 潘俊杰
 * @date 2021年11月13日 21:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_order")
public class Order extends Model<Order> {
    private Long id;
    @TableField(value = "user_id")
    private Long userId;
    @TableField(value = "product_id")
    private Long productId;
    private Integer count;
    private BigDecimal money;
    /**
     * 订单状态：0：创建中；1：已完结
     */
    private Integer status = 0;
}
