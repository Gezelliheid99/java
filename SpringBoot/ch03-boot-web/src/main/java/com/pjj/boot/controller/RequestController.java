package com.pjj.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 潘俊杰
 * @date 2021年09月19日 17:59
 */
@Controller
public class RequestController {

    @GetMapping("/goto")
    public String gotoSuccess(HttpServletRequest request){
        request.setAttribute("msg", "跳转到success");
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute("msg") String msg){
        Map<String, Object> map = new HashMap<>();
        map.put("msg", msg);
        return map;
    }

    @RequestMapping("/haha")
    public String hahaSuccess(Model model){
        model.addAttribute("msg", "hello,thymeleaf!");
        model.addAttribute("link", "http://www.baidu.com");
        return "success";
    }

























}
