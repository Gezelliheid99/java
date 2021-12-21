package com.pjj.dao;

import com.pjj.pojo.Sale;
import org.springframework.stereotype.Repository;

/**
 * @author 潘俊杰
 * @date 2021年08月30日 15:13
 */
@Repository("saleDao")
public interface SaleDao {
    int insertSale(Sale sale);
}
