package com.pjj.springcloud.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 潘俊杰
 * @date 2021年10月16日 20:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment{
    private long id;
    private String serial;
}
