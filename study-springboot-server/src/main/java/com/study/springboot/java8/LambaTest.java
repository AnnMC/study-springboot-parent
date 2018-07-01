package com.study.springboot.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class LambaTest {

    public static void main(String[] args) {
        List<String> list = getStrs();

        Optional<List> optionalList = Optional.of(list);

        if (optionalList.isPresent()) {
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


        ConcurrentSkipListMap<String, String> listMap = new ConcurrentSkipListMap();

        listMap.put("xx","yy");
        System.out.println(listMap.containsKey("xx"));
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
        System.out.println("线程正在执行：" + Thread.currentThread().getName());
    }
}
