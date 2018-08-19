package study.springboot.all.study.springboot.all.annotation;

import java.lang.annotation.*;

/**
 * 异常重试注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface RetryProcess {
    /**
     * 异常重试次数
     *
     * @return
     */
    int value() default 1;
}