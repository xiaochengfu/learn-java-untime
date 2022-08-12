package com.xiaochengfu.springbootstudy;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class VolatileTests {

     private volatile int num = 0;

    /**
     * 知识点：
     * 1. volatile 可见性,参考链接：https://blog.csdn.net/xueping_wu/article/details/124541419
     * 2. 线程的使用new Thread().start();
     * 3. 挂起线程的使用,包java.util.concurrent.TimeUnit
     * 4. System.out.println的方法，内部用到了synchronized
     *
     */
    @Test
    public void visible() {
        new Thread(
                () -> {
                    try {
                        // Thread.sleep(1000);也可以
                        TimeUnit.SECONDS.sleep(1);//暂停线程
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    add10();
                    System.out.println("主线程变量值未改变,等待..."+this.num);
                }
        ).start();

        while (this.num==0){
            System.out.println("循环内打印的话，在不加volatile的情况下，也会实现可见性，因为打印的底层调用了synchronized...");
        }
        System.out.println("子线程内的内存变量->主内存通知主线程"+this.num);
    }

    private void add10() {
        this.num +=10;
    }
}
