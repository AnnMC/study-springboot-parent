package com.study.springboot.service.impl;

import com.study.springboot.dao.UserDAO;
import com.study.springboot.model.UserDO;
import com.study.springboot.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDO getUser() {
        return null;
    }

    @Override
    public UserDO getUserByParam(UserDO userDo) {
        UserDO userDO = userDAO.selectByPrimaryKey(userDo.getId());
        return userDO;
    }

    @Override
    public void insertUser(UserDO userDO) {
        userDO.setName("hahah");
        userDO.setAge(33);
        userDO.setAddress("random");
        userDAO.insertSelective(userDO);
    }
}
