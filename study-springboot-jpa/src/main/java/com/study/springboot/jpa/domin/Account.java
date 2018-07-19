package com.study.springboot.jpa.domin;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @Author Andy
 * @Description TODO
 * @Date 2018/7/9 21:39
 * @class
 */
@Entity
@Table(name = "t_account")
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private BigDecimal amout;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserDO user;
}
