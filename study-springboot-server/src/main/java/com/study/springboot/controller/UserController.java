package com.study.springboot.controller;

import com.study.springboot.model.UserDO;
import com.study.springboot.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value =  "hello接口，返回输入的信息")
    @RequestMapping(value ="/hello" ,method = RequestMethod.GET)
    public String hello(String name) {
        return "Hi:" + name;
    }

    @ApiOperation(value ="获取用户信息！" ,notes = "后台自动返回！")
    @RequestMapping(value = "/getUserDO", method = RequestMethod.GET)
    @ResponseBody
    public UserDO getUserDO() {
        UserDO UserDO = new UserDO();
        UserDO.setId(1000);
        UserDO.setName("Hello");
        return UserDO;
    }

    @ApiOperation(value = "返回Map结构的User对象")
    @RequestMapping(value = "/getUserDOMap", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, UserDO> getUserDOMap() {
        UserDO UserDO = new UserDO();
        UserDO.setId(1000);
        UserDO.setName("Hello");
        Map<String, UserDO> map = new HashMap<>();
        map.put(UserDO.getId().toString(), UserDO);
        return map;
    }

    @ApiOperation(value = "根据id查询对应对象")
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    @ResponseBody
    public UserDO getUserById(Integer id) {
        UserDO UserDO = new UserDO();
        UserDO.setId(id);
        return userService.getUserByParam(UserDO);
    }

    @ApiOperation(value ="插入对象")
    @RequestMapping(value = "/insertUser")
    public Boolean insertUser() {
        try {
            userService.insertUser(new UserDO());
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @ApiOperation(value ="插入对象")
    @ApiImplicitParam(name = "userDo",value = "用户实体对象")
    @RequestMapping(value = "/insertUserTemp", method = RequestMethod.POST)
    public Boolean insertUserTemp(@RequestBody UserDO userDo) {
        try {
            userService.insertUser(new UserDO());
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
