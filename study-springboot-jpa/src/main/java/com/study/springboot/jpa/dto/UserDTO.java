package com.study.springboot.jpa.dto;

import com.study.springboot.jpa.domin.BaseDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 */
@Data
public class UserDTO extends BaseDO implements Serializable {
    private static final long serialVersionUID = -7725172630743537933L;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "地址")
    private String address;


}
