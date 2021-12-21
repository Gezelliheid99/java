package com.pjj.boot.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 潘俊杰
 * @date 2021年09月26日 16:32
 */
@Data
public class Goods extends Model<Goods> {
    @TableId(
            value = "id",
            type = IdType.ASSIGN_UUID
    )
    private String id;
    private String name;
    private Integer amount;
    private BigDecimal price;
}
