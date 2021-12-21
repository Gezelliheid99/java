package com.pjj.dao;

import com.pjj.pojo.ProductInfo;
import com.pjj.pojo.vo.ProductInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (ProductInfo)表数据库访问层
 *
 * @author makejava
 * @since 2021-09-06 19:16:44
 */
public interface ProductInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    ProductInfo queryById(Integer pId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ProductInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param productInfo 实例对象
     * @return 对象列表
     */
    List<ProductInfo> queryAll(ProductInfo productInfo);

    /**
     * 新增数据
     *
     * @param productInfo 实例对象
     * @return 影响行数
     */
    int insert(ProductInfo productInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ProductInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ProductInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ProductInfo> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<ProductInfo> entities);

    /**
     * 修改数据
     *
     * @param productInfo 实例对象
     * @return 影响行数
     */
    int update(ProductInfo productInfo);

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 影响行数
     */
    int deleteById(Integer pId);

    /**
     * 降序查询所有
     * @param condition
     * @return
     */
    List<ProductInfo> queryAllOrderDesc(String condition);

    /**
     * 批量删除商品项
     * @param ids
     * @return
     */
    int deleteBatch(@Param("array") String[] ids);

    List<ProductInfo> selectCondition(ProductInfoVo vo);










}




















