package com.xiaochengfu.springbootstudy.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Person {

    public static final Integer MAN = 1;//男
    public static final Integer WOMAN = 2;//女

    /**
     * 用户id
     */
    private Long id;
    private String name;
    @JSONField(serialize = false,deserialize = false)
    private String pwd;
    /**
     * 地址
     * name = "address":指定属性名和json字符串key的对应关系 addr---address
     */
//    @JSONField(name = "address")
    private String addr;
    /**
     * 网站
     */
    private String websiteUrl;
    @JSONField(name = "resister_date",format = "yyyy-MM-dd")
    private Date registerDate;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthDay;
    private Integer sex;
    private String sexTxt;
}