package study.springboot.all.study.springboot.all.aspect;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import study.springboot.all.study.springboot.all.annotation.RetryProcess;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

@Aspect
@Configuration
public class RetryAspect {
    private static Logger logger = LoggerFactory.getLogger(RetryAspect.class);

    @Pointcut(value = "@annotation(study.springboot.all.study.springboot.all.annotation.RetryProcess)")
    public void run() {
    }

    @AfterThrowing("run()")
    public void tryAgain(JoinPoint point) {
        try {
            Object object = point.getTarget();
            Field field = object.getClass().getDeclaredField("threadLocal");
            field.setAccessible(true); // 设置属性可见

            ThreadLocal<AtomicInteger> threadLocal = (ThreadLocal<AtomicInteger>) field.get(object);

            // 获取注解
            MethodSignature signature = (MethodSignature) point.getSignature();
            Method method = signature.getMethod();
            RetryProcess retryProcess = method.getAnnotation(RetryProcess.class);

            if (threadLocal.get() == null) {
                threadLocal.set(new AtomicInteger(1));
            }

            if (threadLocal.get().intValue() <= retryProcess.value()) {
                logger.info("重试开始");
                ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) point;
                proceedingJoinPoint.proceed();
            }
        } catch (Throwable throwable) {
            logger.info(ExceptionUtils.getStackTrace(throwable));
        }
    }
}