package com.xiaochengfu.springbootstudy.controller;

import com.alibaba.fastjson.JSON;
import com.xiaochengfu.springbootstudy.model.Book;
import com.xiaochengfu.springbootstudy.model.Person;
import com.xiaochengfu.springbootstudy.vo.FamilyVO;
import com.xiaochengfu.springbootstudy.vo.ResultVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class FastjsonController extends AbstractController{


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

    /**
     *知识点：
     * 1. 返回的时候，head中的content-type设为application/json,
     * 通过设置RequestMapping注解的produces （已在继承AbstractController的类中实现）
     * 2. fastjson将对象转为json字符串
     * @return json
     */
    @RequestMapping(value = "/response-json",method = RequestMethod.GET)
    public String contentTypeJson() {
        Person person = new Person();
        person.setName("hp");
        person.setAddr("beijing");
        return JSON.toJSONString(person);
    }

    /**
     * 知识点：自定义返回值（见familyMember方法介绍）
     * @return json
     */
    @RequestMapping(value = "/response-hashmap-json", method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String hashmapJson(){
        FamilyVO familyVO = new FamilyVO();
        return familyVO.familyMember();
    }

    /**
     * 知识点：
     * 1. 返回的object,响应会自动转为json
     * 2. 构建成功时的接口格式
     * @return object
     */
    @RequestMapping(value = "/response-ajax-ok",method = RequestMethod.GET)
    @ResponseBody
    public Object ajaxOk(){
        FamilyVO familyVO = new FamilyVO();
        Object result = familyVO.familyMemberObject();
        return ResultVO.success(result);
    }

    @RequestMapping(value = "/response-ajax-fail",method = RequestMethod.GET)
    @ResponseBody
    public Object ajaxFail(){
        return ResultVO.fail();
    }
}
