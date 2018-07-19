package com.study.springboot.jpa.service.impl;

import com.study.springboot.jpa.dao.HelloWorldDao;
import com.study.springboot.jpa.domin.UserDO;
import com.study.springboot.jpa.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("helloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService {
    @Autowired
    private HelloWorldDao helloWorldDao;

    /**
     * Serivce :业务处理
     *
     * @param str
     * @return
     */
    @Override
    public String input(String str) {
        UserDO userDO = new UserDO();

        if (str.equals(1)) {
            // select * from t_user t.id = "";
            userDO = helloWorldDao.queryById(1L);
        } else {
            userDO = helloWorldDao.queryById(2L);
        }

        if (userDO.getPassword().equals("10")) {
            return "密码是10";
        } else {
            return "密码未知";
        }
    }
}
