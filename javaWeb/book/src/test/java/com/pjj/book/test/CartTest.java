package com.pjj.book.test;

import com.pjj.book.pojo.Cart;
import com.pjj.book.pojo.CartItems;
import org.junit.Test;
import org.junit.experimental.categories.Categories;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItems(1,"java从入门到入狱",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItems(2,"java1",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItems(3,"java2",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItems(4,"java3",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItems(4,"java3",1,new BigDecimal(1000),new BigDecimal(1000)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem(){
        Cart cart = new Cart();
        cart.addItem(new CartItems(3,"java2",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItems(4,"java3",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItems(4,"java3",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.deleteItem(4);
        System.out.println(cart);

    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItems(1,"java从入门到入狱",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItems(2,"java1",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItems(3,"java2",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItems(4,"java3",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItems(4,"java3",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItems(1,"java从入门到入狱",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItems(2,"java1",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.updateCount(1,2);
        System.out.println(cart);
    }
}