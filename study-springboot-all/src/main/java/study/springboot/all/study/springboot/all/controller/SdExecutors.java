package study.springboot.all.study.springboot.all.controller;

import study.springboot.all.study.springboot.all.thread.SdThreadPoolExecutor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class SdExecutors {
    private static SdThreadPoolExecutor sdThreadPoolExecutor = new SdThreadPoolExecutor(8, 20, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    public static SdThreadPoolExecutor getSdThreadPoolExecutor() {
        return sdThreadPoolExecutor;
    }
}
