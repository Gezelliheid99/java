package com.pjj.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 潘俊杰
 * @date 2021年10月31日 16:02
 */
@RestController
public class OrderController {
    @Resource
    private RestTemplate template;

    @Value("${service-url.nacos-user-service}")
    private String ServiceUrl;

    @GetMapping("/consumer/nacos/{id}")
    public String getNacos(@PathVariable("id") Integer id) {
        return template.getForObject(ServiceUrl + "/payment/nacos/" + id, String.class);
    }

}
