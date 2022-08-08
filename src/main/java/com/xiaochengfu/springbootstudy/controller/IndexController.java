package com.xiaochengfu.springbootstudy.controller;

import com.xiaochengfu.springbootstudy.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;


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
     * @return
     */
    @GetMapping("/get")
    public String get(){
        return "method get";
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

    /**
     * 知识点：
     * 1. 返回json格式，在类中导入jackson
     * 2. 类中省略getter/setter,引入依赖lombok, 在类中使用注解 @Getter @Setter 或 @Data,编辑中安装插件 lombok
     * @return book
     */
    @RequestMapping("/json")
    @ResponseBody
    public Book json(){
        Book book = new Book();
        book.setName("三国演义");
        book.setAuthor("罗贯中");
        book.setPrice(30D);
        book.setCationDate(new Date());
        return book;
    }

}
