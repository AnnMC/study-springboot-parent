package com.study.springboot.controller;

import com.study.springboot.redis.RangeManager;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Request;

import java.util.Set;

/**
 *
 */
@RestController
@RequestMapping(value = "/redis")
public class RedisController {

    @Autowired
    private RangeManager rangeManager;

    @ApiOperation(value = "初始化redis数据")
    @RequestMapping(value = "/init",method = RequestMethod.POST)
    public Boolean init() {
        return rangeManager.initRange();
    }

    @ApiOperation(value ="获取排名！")
    @RequestMapping(value = "/getRange",method = RequestMethod.GET)
    public Set<String> getRange(Integer index) {
        return rangeManager.getRange(index);
    }
}
