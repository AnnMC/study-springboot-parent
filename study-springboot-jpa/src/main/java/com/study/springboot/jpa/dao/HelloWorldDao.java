package com.study.springboot.jpa.dao;

import com.study.springboot.jpa.domin.UserDO;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloWorldDao extends BaseResponsity<UserDO, Long> {
    UserDO queryById(Long id);
}
