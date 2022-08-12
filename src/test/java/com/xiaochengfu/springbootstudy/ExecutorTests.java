package com.xiaochengfu.springbootstudy;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ExecutorTests {
    volatile int num = 0;

    private static final Logger logger = LoggerFactory.getLogger(ExecutorTests.class);

    /**
     * 知识点：
     * 1. newSingleThreadScheduledExecutor单线程调度
     * 2. scheduleWithFixedDelay 延时执行任务
     * 3. slf4j.Logger的日志使用
     * @throws InterruptedException
     */
    @Test
    public void delayExec() throws InterruptedException {
        ExecutorTests tmp = this;
        //起一个单线程，执行任务
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(false);
                return thread;
            }
        });
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                tmp.setNum(10);
                logger.info("延时执行");
            }
        }, 1, 1, TimeUnit.SECONDS);

        System.out.println(tmp.getNum());
        while (true){
            TimeUnit.SECONDS.sleep(1);
            System.out.println("定时任务执行完成，num:"+tmp.getNum());
        }
    }

    public void setNum(Integer num) {
        this.num += num;
    }

    public Integer getNum() {
        return this.num;
    }
}
