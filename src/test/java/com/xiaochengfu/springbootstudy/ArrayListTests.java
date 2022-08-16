package com.xiaochengfu.springbootstudy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ArrayListTests {

    @Test
    public void arrayList()
    {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        ArrayList<String> list2 = new ArrayList<>(list);

        Set<String> removeCollection = new HashSet<>(list2);//要删除的key
        removeCollection.remove("a");
        HashMap<String, String> mapCollection = new HashMap<>();
        mapCollection.put("A","a");
        mapCollection.put("B","b");
        //keySet()返回key的集合视图
        Set<String> setCollection = new HashSet<>(mapCollection.keySet());
        System.out.println(setCollection); //[A, B]
        System.out.println(list2.toString());//[a, b]
        System.out.println(removeCollection.toString());//[b]
    }
}
