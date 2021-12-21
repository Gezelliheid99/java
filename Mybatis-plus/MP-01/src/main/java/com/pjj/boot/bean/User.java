package com.pjj.boot.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @author 潘俊杰
 * @date 2021年09月25日 17:31
 */

@Data
public class User extends Model<User>{
    /**
     * 自动增长主键
     */
    @TableId(
            value = "id",
            type = IdType.AUTO
    )
    private Integer id;
    private String name;
    private String email;
    private Integer age;
}
