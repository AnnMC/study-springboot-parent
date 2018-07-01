package com.study.springboot.thread;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SplitThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Integer[] data = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ExecutorService service = Executors.newFixedThreadPool(data.length);
        CountDownLatch latch = new CountDownLatch(data.length);
        for (int i = 0; i < data.length; i++) {
            service.submit(new SplitThread(i, data, latch));
        }

        latch.await();

        service.shutdown();

        System.out.println(Arrays.toString(data));
    }
}


class SplitThread extends Thread {
    private int index;
    private Integer[] data;
    private CountDownLatch latch;

    public SplitThread(int index, Integer[] data, CountDownLatch latch) {
        this.data = data;
        this.index = index;
        this.latch = latch;
    }

    @Override
    public void run() {
        int value = data[index];
        if (value % 2 == 0) {
            data[index] = value * 2;
        } else {
            data[index] = value * 10;
        }

        //
        latch.countDown();
    }
}