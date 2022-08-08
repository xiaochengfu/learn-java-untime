package com.xiaochengfu.springbootstudy.controller;

import com.alibaba.fastjson.JSON;
import com.xiaochengfu.springbootstudy.model.Person;
import com.xiaochengfu.springbootstudy.vo.FamilyVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FastjsonController extends AbstractController{

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
}
