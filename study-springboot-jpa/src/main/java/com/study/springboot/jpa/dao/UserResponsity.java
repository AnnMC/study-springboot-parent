package com.study.springboot.jpa.dao;

import com.study.springboot.jpa.domin.UserDO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Andy
 * @Description TODO
 * @Date 2018/6/30 16:12
 */
@Repository
public interface UserResponsity extends BaseResponsity<UserDO, Long> {

    UserDO queryById(Long id);

    @Modifying
    @Query(value = "update UserDO t set t.userName = :userName where t.id = :id")
    Integer updateUserById(@Param("id") Long id, @Param("userName") String userName);

    List<UserDO> queryByUserName(String name, Pageable pageable);


}
