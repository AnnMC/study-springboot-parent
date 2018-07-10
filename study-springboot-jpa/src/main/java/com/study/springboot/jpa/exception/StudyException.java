package com.study.springboot.jpa.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Andy
 * @Description TODO
 * @Date 2018/7/1 19:27
 */
@ControllerAdvice
public class StudyException {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, RuntimeException e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(ExceptionUtils.getStackTrace(e.getCause()));
        r.setCode(e.hashCode());
        r.setData("Some Data");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }
}
