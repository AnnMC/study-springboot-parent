package com.study.springboot.jpa.schedule;

import com.study.springboot.jpa.domin.UserDO;
import com.study.springboot.jpa.service.UserService;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Andy
 * @Description TODO
 * @Date 2018/6/30 18:43
 */
@Component
public class UserSchedule {
    @Autowired
    private UserService userService;

    //@Scheduled(cron = "0 */1 * * * ?")
    public void insertUser() {
        System.out.println("插入数据任务处理");
        for (int i = 0; i < 10; i++) {
            UserDO userDO = new UserDO();

            userDO.setUserName(i + "");
            userDO.setPassword(RandomUtils.nextLong(100000L, 100000000L) + "");
            userDO.setAddress(getAddress(i));

            System.out.println("插入数据");
            userService.insertUser(userDO);
        }
    }

    public static String getAddress(Integer i) {
        List<String> list = new ArrayList<>();
        list.add("北京市");
        list.add("河北省");
        list.add("吉林省");
        list.add("内蒙");
        i = i % 4;
        return list.get(i);
    }
}
