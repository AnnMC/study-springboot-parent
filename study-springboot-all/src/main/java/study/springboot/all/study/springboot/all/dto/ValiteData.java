package study.springboot.all.study.springboot.all.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

/**
 * 数据验证
 * <p>
 * 1、SpringBoot 数据验证
 */
@Validated
@Data
public class ValiteData {
    @NotBlank(message = "用户名不能为空")
    private String userName;

    @Email(message = "邮件格式不正确")
    private String email;

    @Min(value = 0, message = "最小为0")
    private int age;
}
