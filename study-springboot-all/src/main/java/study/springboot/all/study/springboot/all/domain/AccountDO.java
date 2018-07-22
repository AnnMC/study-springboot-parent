package study.springboot.all.study.springboot.all.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "t_Account")
@Entity
@Data
public class AccountDO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ApiModelProperty(value = "账户余额")
    private BigDecimal balance;

    @Column(name = "create_time")
    private Date createTime;

    private Long createBy;

    @Column(name = "upateTime")
    private Date updateTime;

    private Long updateBy;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //JPA注释： 一对一 关系
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserDO userDO;
}
