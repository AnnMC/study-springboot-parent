package com.study.springboot.jpa.service.impl;

import com.study.springboot.jpa.dao.AccountResponsity;
import com.study.springboot.jpa.dao.UserResponsity;
import com.study.springboot.jpa.domin.Account;
import com.study.springboot.jpa.domin.UserDO;
import com.study.springboot.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Andy
 * @Description TODO
 * @Date 2018/6/30 16:16
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserResponsity userResponsity;

    @Autowired
    private AccountResponsity accountResponsity;

    @Override
    public void insertUser(UserDO userDo) {
        userResponsity.save(userDo);
    }

    @Override
    public UserDO queryUserById(Long id) {
        Account account = accountResponsity.queryById(id);
        return userResponsity.queryById(id);
    }

    @Transactional
    @Override
    public Integer updateUserById(Long id, String userName) {
        return userResponsity.updateUserById(id, userName);
    }

    @Override
    public List<UserDO> queryByUserName(String name, Pageable pageable) {
        return userResponsity.queryByUserName(name, pageable);
    }

    @Override
    public Long countUser() {
        return userResponsity.count();
    }

    @Override
    public void deleteUserById(Long id) {
        userResponsity.deleteById(id);
    }
}
