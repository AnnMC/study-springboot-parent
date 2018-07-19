package com.study.springboot.jpa.filter;


import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Chaos
 * @package cn.magicwindow.score.common.filter
 * @class MwHttpServletRequestWrapper
 * @email chao.sun@magicwindow.cn
 * @date 2018/3/15 23:00
 * @description
 */
public class StudyHttpServletRequestWrapper extends MyRequestWrapper {

    private Map<String, String[]> additionalParams = new HashMap<>();

    private final byte[] body;


    public StudyHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator())).getBytes(Charset.forName("UTF-8"));
    }


    public String getBodyString() {
        return new String(body, Charset.forName("UTF-8"));
    }

}
