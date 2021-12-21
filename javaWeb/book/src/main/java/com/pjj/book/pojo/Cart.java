package com.pjj.book.pojo;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author 潘俊杰
 * @date 2021年08月15日 16:20
 */
public class Cart {
    private Map<Integer,CartItems> items = new LinkedHashMap<>();

    /**
     * 添加商品项
     * @param cartItem
     */
    public void addItem(CartItems cartItem){
        CartItems item = this.items.get(cartItem.getId());
        if (item == null) {
            // 还没添加到购物车中
           items.put(cartItem.getId(), cartItem);
        }else {
            // 已经添加到购物车中
            item.setCount(item.getCount() + 1 );
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    /**
     * 删除商品项
     * @param id
     */
    public void deleteItem(Integer id){
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear(){
         items.clear();
    }

    /**
     * 修改商品数目
     * @param id
     * @param count
     */
    public void updateCount(Integer id,Integer count){
        CartItems cartItem = items.get(id);
        if (cartItem != null) {
            cartItem.setCount(count);  //修改商品数量
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));   //修改商品总额
        }
    }



    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer,CartItems>entry : items.entrySet()){
            totalCount += entry.getValue().getCount();

        }
        return totalCount;
    }



    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice= new BigDecimal(0);
        for (Map.Entry<Integer,CartItems>entry : items.entrySet()){
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());

        }
        return totalPrice;
    }



    public Map<Integer, CartItems> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItems> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }


}
