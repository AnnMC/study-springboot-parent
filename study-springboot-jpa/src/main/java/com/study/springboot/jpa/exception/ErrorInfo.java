package com.study.springboot.jpa.exception;

import lombok.Data;

/**
 * @Author Andy
 * @Description TODO
 * @Date 2018/7/1 19:29
 */
@Data
public class ErrorInfo<T> {
    public static final Integer OK = 0;
    public static final Integer ERROR = 100;

    private Integer code;
    private String message;
    private String url;
    private T data;
}
