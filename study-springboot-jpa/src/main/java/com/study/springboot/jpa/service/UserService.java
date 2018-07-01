package com.study.springboot.jpa.service;

import com.study.springboot.jpa.domin.UserDO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author Andy
 * @Description //TODO
 * @Date 2018/6/30 16:14
 */
public interface UserService {
    /**
     * 插入
     *
     * @param userDo
     */
    void insertUser(UserDO userDo);

    UserDO queryUserById(Long id);

    Integer updateUserById(Long id, String userName);

    List<UserDO> queryByUserName(String name, Pageable pageable);

    Long countUser();
}
