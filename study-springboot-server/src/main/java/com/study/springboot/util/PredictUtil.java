package com.study.springboot.util;

import com.study.springboot.model.UserDO;

import java.util.Optional;

/**
 * @Author Andy
 * @Description TODO
 * @Date 2018/7/1 16:47
 */
public class PredictUtil<T extends Object> {
    /**
     * 判断对象是否为空
     */
    public static <T> boolean isEmpty(T t) {
        Optional<T> optionalT = Optional.of(t);
        return optionalT.isPresent();
    }

    /**
     * 判断对象是否为空
     */
    public static <T> boolean isNotEmpty(T t) {
        Optional<T> optionalT = Optional.of(t);
        return optionalT.isPresent();
    }

    public static void main(String args[]) {
        System.out.println(PredictUtil.isEmpty(5));
        System.out.println(PredictUtil.isEmpty(new UserDO()));
        System.out.println(PredictUtil.isEmpty(""));
        System.out.println(PredictUtil.isEmpty(false));
    }
}
