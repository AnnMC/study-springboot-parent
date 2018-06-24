package com.study.springboot.service;

import com.study.springboot.model.UserDO;

/**
 * 用户信息处理
 */
public interface UserService {
    public UserDO getUser();

    public UserDO getUserByParam(UserDO userDo);

    public void insertUser(UserDO userDO);
}
