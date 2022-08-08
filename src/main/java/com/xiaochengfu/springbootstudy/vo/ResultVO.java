package com.xiaochengfu.springbootstudy.vo;


import java.util.HashMap;

public class ResultVO<T> extends HashMap<String,Object> {

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

    public ResultVO(int code,String msg){
        super.put(CODE_TAG,code);
        super.put(MSG_TAG,msg);
    }

    public ResultVO(int code,String msg,T data){
        super.put(CODE_TAG,code);
        super.put(MSG_TAG,msg);
        if (data != null){
            super.put(DATA_TAG,data);
        }else {
            super.put(DATA_TAG,"");
        }
    }

    public static <T> ResultVO<T> success(T data) {
        return new ResultVO<>(0, "成功", data);
    }

    public static <T> ResultVO<T> success() {
        return new ResultVO<>(0, "成功", null);
    }

    public static <T> ResultVO<T> fail() {
        return new ResultVO<>(10000, "系统错误");
    }

    public static <T> ResultVO<T> fail(int code) {
        return new ResultVO<>(code, "系统错误");
    }

}
