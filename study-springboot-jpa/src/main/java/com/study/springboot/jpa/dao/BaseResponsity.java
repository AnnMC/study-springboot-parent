package com.study.springboot.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @Author Andy
 * @Description //TODO
 * @Date xx$ xx$
 */
@NoRepositoryBean
public interface BaseResponsity<T, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor {

}
