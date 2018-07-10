package com.study.springboot.jpa.dao;

import com.study.springboot.jpa.domin.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author Andy
 * @Description TODO
 * @Date 2018/7/9 21:45
 * @class
 */
@Repository
public interface AccountResponsity extends BaseResponsity<Account, Long> {
    Account queryById(Long id);

    @Query("select a from Account a where a.id =:id")
    Account queryByParam(@Param("id") Long id);
}
