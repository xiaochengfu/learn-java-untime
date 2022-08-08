package com.xiaochengfu.springbootstudy.model;

import lombok.Data;

@Data
public class Family {

    private Long id;
    private Integer memberNum;
    private String father;
    private String mather;

    private String addr;


}
