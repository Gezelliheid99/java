package com.pjj.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pjj.springcloud.pojo.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 潘俊杰
 * @date 2021年11月14日 19:03
 */
@Mapper
public interface StorageMapper extends BaseMapper<Storage> {
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}
