package com.pjj.boot.controller;

import com.pjj.boot.bean.Goods;
import com.pjj.boot.bean.User;
import com.pjj.boot.service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

/**
 * @author 潘俊杰
 * @date 2021年09月23日 17:43
 */
@Controller
public class IndexController {

    @Autowired
    GoodsServiceImpl service;


    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if (StringUtils.hasLength(user.getUserName()) && "111".equals(user.getPassword())){
            session.setAttribute("loginUser", user);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg", "账号或密码错误");
            return "login";
        }

    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
        return "main";
    }

    @ResponseBody
    @RequestMapping("/goods")
    public Goods selectGoods(@RequestParam("id") Integer id){
        return service.selectGoodsById(id);
    }

    @ResponseBody
    @GetMapping("/insert")
    public int insertGoods(@RequestParam("id") Integer id,
                           @RequestParam("name") String name,
                           @RequestParam("amount") Integer amount,
                           @RequestParam("price") BigDecimal price){
        Goods goods = new Goods();
        goods.setId(Long.valueOf(id));
        goods.setName(name);
        goods.setAmount(amount);
        goods.setPrice(price);
        return service.insertGoods(goods);
    }

    @ResponseBody
    @GetMapping("/i")
    public Goods insert(Goods goods){
        service.insertGood(goods);
        return goods;
    }

}
