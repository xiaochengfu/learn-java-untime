package com.xiaochengfu.springbootstudy;

import com.xiaochengfu.springbootstudy.model.Book;
import org.junit.jupiter.api.Test;

import java.util.*;

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

    /**
     * 知识点：
     * 1. 数组的声明、创建和初始化
     */
    @Test
    public void array()
    {
        String str = "hello world";
        System.out.println(str);
        int[] num; //声明数组
        num = new int[5]; //创建数组
        num[0] = 1;
        num[1] = 2;
        System.out.println(Arrays.toString(num));
        int[] number = new int[5]; //声明的同时创建数组
        number[0] = 1;
        number[1] = 2;
        System.out.println(Arrays.toString(number));
        int[] numbers = new int[]{1,2,3,4,5}; //声明的同时创建数组并初始化
        System.out.println(Arrays.toString(numbers));
        Book[] books; //声明数组
        //创建数组的同时，初始化数组,初始化时，数组的长度就是初始化时所给数组元素的个数，下面books数组的长度就是2
        books = new Book[]{new Book(),new Book()};
        System.out.println(Arrays.toString(books));
    }
}
