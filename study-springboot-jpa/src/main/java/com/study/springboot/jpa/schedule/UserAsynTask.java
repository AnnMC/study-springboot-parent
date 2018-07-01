package com.study.springboot.jpa.schedule;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Author Andy
 * @Description TODO
 * @Date 2018/7/1 15:12
 */
@Component
public class UserAsynTask {
    //定义一个随机对象.
    public static Random random = new Random();

    @Async  //加入"异步调用"注解
    public void doTaskOne() throws InterruptedException {
        System.out.println("开始执行任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
    }
}
