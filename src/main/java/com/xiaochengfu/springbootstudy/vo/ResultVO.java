package com.xiaochengfu.springbootstudy.vo;

import lombok.Data;

@Data
public class ResultVO<T> {
    private T data;

    /**
     * 状态码
     */
    public static final String CODE_TAG = "code";

    /**
     * 返回内容
     */
    public static final String MSG_TAG = "msg";

    /**
     * 数据对象
     */
    public static final String DATA_TAG = "data";

    public ResultVO() {
    }

    public static <T> ResultVO<T> success(T data) {
        ResultVO<T> objectResultVo = new ResultVO<>();
        objectResultVo.setData(data);
        return objectResultVo;
    }

}
