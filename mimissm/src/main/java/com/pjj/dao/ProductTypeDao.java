package com.pjj.dao;

import com.pjj.pojo.ProductType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (ProductType)表数据库访问层
 *
 * @author makejava
 * @since 2021-09-06 19:16:48
 */
public interface ProductTypeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    ProductType queryById(Integer typeId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ProductType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param productType 实例对象
     * @return 对象列表
     */
    List<ProductType> queryAll(ProductType productType);

    /**
     * 新增数据
     *
     * @param productType 实例对象
     * @return 影响行数
     */
    int insert(ProductType productType);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ProductType> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ProductType> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ProductType> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<ProductType> entities);

    /**
     * 修改数据
     *
     * @param productType 实例对象
     * @return 影响行数
     */
    int update(ProductType productType);

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 影响行数
     */
    int deleteById(Integer typeId);

}

