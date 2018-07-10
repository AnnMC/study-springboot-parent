package com.study.springboot.jpa.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Andy
 * @Description TODO
 * @Date 2018/7/1 19:34
 */
@Order(1)
@WebFilter(filterName = "HttpRequestFilter", urlPatterns = "/api/*")
public class HttpRequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器处理");

        StudyHttpServletRequestWrapper wrapper = new StudyHttpServletRequestWrapper((HttpServletRequest) servletRequest);

        wrapper.addParameter("userId", new String[]{"122343"});

        filterChain.doFilter(wrapper, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
