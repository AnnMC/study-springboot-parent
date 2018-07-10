package com.study.springboot.jpa.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Andy
 * @Description TODO
 * @Date 2018/7/6 22:37
 */
public class MyRequestWrapper extends HttpServletRequestWrapper {
    private Map<String, String[]> additionalParams = new HashMap<>();

    public MyRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    public void addParameter(String name, String[] val) {
        additionalParams.put(name, val);
    }

    @Override
    public String getParameter(final String name) {
        String[] vals = additionalParams.get(name);
        if (vals != null && vals.length > 0) {
            return vals[0];
        }
        return super.getParameter(name);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> combinedParameterMap = new HashMap<>();
        combinedParameterMap.putAll(getRequest().getParameterMap());
        combinedParameterMap.putAll(additionalParams);
        return combinedParameterMap;
    }


    @Override
    public String getQueryString() {
        return "";
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] vals = additionalParams.get(name);
        if (vals != null) {
            return vals;
        }
        return super.getParameterValues(name);
    }
}
