package com.study.springboot.jpa.domin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 */
@Table(name = "t_user")
@Entity
@Data
public class UserDO extends BaseDO implements Serializable {
    private static final long serialVersionUID = -7725172630743537933L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "id")
    private Long id;

    @Column(name = "user_name", nullable = false, length = 50)
    @ApiModelProperty(value = "用户名")
    private String userName;

    @Column(name = "password", nullable = false, length = 50)
    @ApiModelProperty(value = "密码")
    private String password;

    @Column(name = "address")
    @ApiModelProperty(value = "地址")
    private String address;


    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
