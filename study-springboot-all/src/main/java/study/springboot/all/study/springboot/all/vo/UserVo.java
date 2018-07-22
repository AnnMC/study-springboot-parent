package study.springboot.all.study.springboot.all.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import study.springboot.all.study.springboot.all.domain.UserDO;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 */
@Data
public class UserVo extends UserDO implements Serializable {
    private static final long serialVersionUID = -6132109877722198934L;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "地址")
    private String address;
}
