package com.pjj.boot.controller;

import org.springframework.web.bind.annotation.*;

import javax.management.ValueExp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 潘俊杰
 * @date 2021年09月17日 14:09
 */
@RestController
public class Controller {


    @RequestMapping("/hello")
    public String hello() {
        return "aaa";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser() {
        return "GET-User";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String postUser() {
        return "POST-User";
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public String deleteUser() {
        return "DELETE-User";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String putUser() {
        return "PUT-User";
    }


    @GetMapping("/car/{id}/owner/{name}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("name") String name,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> header,
                                      @RequestParam("age") Integer age,
                                      @RequestParam("interest")List<String> interest,
                                      @RequestParam Map<String, String> params,
                                      @CookieValue("Idea-19859dc9") String cookie){
        Map<String, Object> map = new HashMap<>();
        // map.put("id",id);
        // map.put("name","name");
        // map.put("pv",pv);
        // map.put("userAgent",userAgent);
        // map.put("header",header);
        map.put("age",age);
        map.put("interest",interest);
        map.put("params",params);
        map.put("cookie",cookie);

        return map;
    }


    @PostMapping(value = "/save")
    public Map<String, Object> save(@RequestBody String content){
        Map<String, Object> map = new HashMap<>();
        map.put("content", content);
        return map;
    }



    @RequestMapping("/cars/{path}")
    public Map getCar(@MatrixVariable("low") Integer low,
                         @MatrixVariable("brand") List<String> brand,
                      @PathVariable("path") String path){
        Map<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }

    @RequestMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age",pathVar = "empId") Integer empAge){
        Map<String,Object> map = new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        return map;
    }



















}
