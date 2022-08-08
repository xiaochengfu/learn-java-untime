package com.xiaochengfu.springbootstudy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = "application/json;charset=UTF-8") //对下面所有的方法都生效
public class AbstractController {

}
