package com.xiaochengfu.springbootstudy;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class ConcurrentHashMapTests {

    /**
     * 知识点：
     * 1. ConcurrentHashMap可以保证线程安全，参考：https://www.cnblogs.com/askfb/p/15307821.html
     * 2. Stream.of创建顺序流，可以创建数字、字符、对象流
     */
    @Test
    public void hashmap(){
        ConcurrentHashMap<String, Integer> visitHashMap = new ConcurrentHashMap<>();
        visitHashMap.put("a",1);
        visitHashMap.putIfAbsent("a", 2);//如果key不存在则设置
        visitHashMap.computeIfAbsent("a", (k) -> 10);//如果key不存在则设置
        visitHashMap.computeIfPresent("a", (k, v) -> v+10);
        if(visitHashMap.containsKey("a")){
            System.out.println("包含key:a");
        }
        if(visitHashMap.containsValue(11)){
            System.out.println("包含val:11");
        }
        System.out.printf("%s ,size: %d",visitHashMap.toString(),visitHashMap.size());
        System.out.println();
        visitHashMap.remove("a");
        System.out.println(visitHashMap.toString());
        Stream.of("a","b","c","d","e","f","g").forEach(v->{
            Random random = new Random();
            visitHashMap.put(v,random.nextInt());
        });
        System.out.println(visitHashMap.toString());
    }
}
