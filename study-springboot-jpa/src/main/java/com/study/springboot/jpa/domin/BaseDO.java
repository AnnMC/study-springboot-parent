package com.study.springboot.jpa.domin;


import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author andy zhou
 * @Title: BaseDO
 * @ProjectName spring-boot-web
 * @Description: TODO
 * @date 2018/6/30 13:52
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseDO {
    @Column(name = "is_delete", columnDefinition = "tinyInt default 0", length = 1)
    private Integer isDelete;

    @Column(name = "create_time")
    @Temporal(TemporalType.DATE)
    private Date createTime;

    @Column(name = "update_time", updatable = true)
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
}
