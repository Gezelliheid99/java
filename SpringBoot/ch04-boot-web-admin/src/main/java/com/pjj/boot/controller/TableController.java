package com.pjj.boot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pjj.boot.bean.ProductInfo;
import com.pjj.boot.bean.User;
import com.pjj.boot.exception.UserTooManyException;
import com.pjj.boot.service.GoodsService;
import com.pjj.boot.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.TooManyListenersException;

/**
 * @author 潘俊杰
 * @date 2021年09月24日 14:02
 */
@Controller
public class TableController {

    @Autowired
    ProductInfoService service;

    @GetMapping("/basic_table")
    public String basicTable(){
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public  String dynamicTable(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                Model model) {
        Page<ProductInfo> Propage = new Page<>(page, 5);
        Page<ProductInfo> productInfoPage = service.page(Propage, null);
        List<ProductInfo> records = productInfoPage.getRecords();
        model.addAttribute("page", productInfoPage);
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsiveTable(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editableTable(){
        return "/table/editable_table";
    }


}
