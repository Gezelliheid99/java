package com.pjj.service.impl;

import com.pjj.dao.GoodsDao;
import com.pjj.dao.SaleDao;
import com.pjj.exception.NotEnoughException;
import com.pjj.pojo.Goods;
import com.pjj.pojo.Sale;
import com.pjj.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author 潘俊杰
 * @date 2021年08月30日 15:35
 */
@Service("buyService")
public class GoodsServiceImpl implements GoodsService {

    @Resource(name = "saleDao")
    private SaleDao saleDao = null;

    @Resource(name = "goodsDao")
    private GoodsDao goodsDao = null;

    @Transactional(
            rollbackFor = {
                    NullPointerException.class,NotEnoughException.class
            }
    )
    @Override
    public void buy(Integer goodsId, Integer nums) {
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);
        saleDao.insertSale(sale);
        Goods goods = goodsDao.selectGoodsById(goodsId);
        if (goods == null) {
            throw new NullPointerException("商品不存在");
        }else if (goods.getAmount() < nums){
            throw new NotEnoughException("商品数量不足");
        }
        Goods buyGood = new Goods();
        buyGood.setId(goodsId);
        buyGood.setAmount(nums);
        goodsDao.updateGoods(buyGood);
    }
}















