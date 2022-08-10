package com.xiaochengfu.springbootstudy.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;


@RestController
public class IndexController {

    /**
     * 知识点：
     * 1. RequestMapping请求（get/post都可以）
     * @return str
     */
    @RequestMapping("/")
    public String hi() {
        return "hello world";
    }

    /**
     * 知识点：
     * 1. get请求
     */
    @GetMapping("/get")
    public String get(){
        return "method get";
    }

    /**
     * 知识点：
     * 1. PathVariable注解，获取伪静态url中的参数,如：http://localhost:8080/get-params/order/30
     * @param id id
     * @param type type
     * @return
     */
    @RequestMapping("/get-params/{type}/{id}")
    public Object getParams(@PathVariable String id, @PathVariable String type){
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("type",type);
        stringObjectHashMap.put("id",id);
        return stringObjectHashMap;
    }

    /**
     * 知识点：
     * 1. 注解RequestParam,获取url链接中的参数，如: http://localhost:8080/get-params-more?type=order&id=30
     * @param type 类型
     * @param id id
     * @return object
     */
    @RequestMapping("/get-params-more")
    public Object getParams(@RequestParam(value = "type") String type, @RequestParam(value = "id",required = false) Integer id){
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("type",type);
        stringObjectHashMap.put("id",id);
        return stringObjectHashMap;
    }

    /**
     * 知识点：
     * 1. 泛型使用 <>
     * 2. ArrayList结合的使用
     * @return str
     */
    @RequestMapping("/fanxing")
    public String fanXing(){
        ArrayList<String> list = new ArrayList<>();
        list.add("hp");
        list.add("study");
        String str = "";
        for (int i = 0;i < list.size();i++){
            String s = list.get(i);
            str = str.concat(s);
        }
        return str;
    }


}
