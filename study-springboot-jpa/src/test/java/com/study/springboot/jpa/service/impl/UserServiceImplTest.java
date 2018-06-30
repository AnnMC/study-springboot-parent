package com.study.springboot.jpa.service.impl;

import com.study.springboot.jpa.domin.UserDO;
import com.study.springboot.jpa.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void insertUser() {
        for (int i = 0; i < 10; i++) {
            UserDO userDO = new UserDO();

            userDO.setUserName(i + "");
            userDO.setPassword(i * 10 + "");
            userDO.setAddress("北京");

            userService.insertUser(userDO);
        }
    }

    @Test
    public void queryUserById() {

        UserDO userDo = userService.queryUserById(1L);
        System.out.println(userDo.toString());
    }

    @Test
    public void updateUserById() {
        userService.updateUserById(1L, "lili");
    }

    @Test
    public void queryByUserName() {
        Pageable pageable = new QPageRequest(1, 2);
        List<UserDO> list = userService.queryByUserName("feifei", pageable);
        System.out.println(list.size());
    }
}