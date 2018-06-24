package com.study.springboot.java8;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class LambaTest {

    public static void main(String[] args) {
        List<String> list = getStrs();

        /**
         * 遍历
         */
        list.forEach(str -> {
            if (str.startsWith("l")) {
                System.out.println(str);
            }
        });

        /**
         * 处理线程
         */
        new Thread(() -> {
            LambaTest.getInteger();
        }).start();
    }

    public static List<String> getStrs() {
        List<String> list = new ArrayList<String>();

        list.add("zhangsan");
        list.add("lisi");
        list.add("wanger");
        list.add("linlin");
        list.add("meili");

        return list;
    }

    public static void getInteger() {
        System.out.println(Thread.currentThread().getName());
    }
}
