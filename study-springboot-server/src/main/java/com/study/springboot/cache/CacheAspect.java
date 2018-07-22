package com.study.springboot.cache;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.lang.reflect.Method;

@Component
@Aspect
public class CacheAspect {
    @Resource
    public RedisCacheBean redis;

    /**
     * 定义缓存逻辑
     */
    @Around("@annotation(com.study.springboot.cache.CacheAround)")
    public Object cache(ProceedingJoinPoint pjp) {
        Object result = null;
        Boolean cacheEnable = true;
        //判断是否开启缓存
        if (!cacheEnable) {
            try {
                result = pjp.proceed();
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return result;
        }

        Method method = getMethod(pjp);
        CacheAround cacheable = method.getAnnotation(CacheAround.class);

        String fieldKey = parseKey(cacheable.fieldKey(), method, pjp.getArgs());

        //获取方法的返回类型,让缓存可以返回正确的类型
        Class returnType = ((MethodSignature) pjp.getSignature()).getReturnType();

        //使用redis 的hash进行存取，易于管理
        result = redis.hget(cacheable.key(), fieldKey, returnType);

        if (result == null) {
            try {
                result = pjp.proceed();
                Assert.notNull(fieldKey);
                redis.hset(cacheable.key(), fieldKey, result);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /*** 定义清除缓存逻辑*/
    @Around(value = "@annotation(com.yeepay.g3.core.payplus.test.utils.MultiCacheEvict)")
    public Object evict(ProceedingJoinPoint pjp) {
        Object result = null;
        Boolean cacheEnable = true;
        //判断是否开启缓存
        if (!cacheEnable) {
            try {
                result = pjp.proceed();
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return result;
        }

        Method method = getMethod(pjp);
        CacheEvict cacheable = method.getAnnotation(CacheEvict.class);
        String fieldKey = parseKey(cacheable.fieldKey(), method, pjp.getArgs());

        //获取方法的返回类型,让缓存可以返回正确的类型
        Class returnType = ((MethodSignature) pjp.getSignature()).getReturnType();
        //使用redis 的hash进行存取，易于管理
        result = redis.hget(cacheable.key(), fieldKey);
        if (result != null) {
            redis.hdel(cacheable.key(), fieldKey);
            //执行真正的删除，先更新数据库在更新缓存是最好的方案
            try {
                result = pjp.proceed();
            } catch (Throwable e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 获取被拦截方法对象
     * <p>
     * MethodSignature.getMethod() 获取的是顶层接口或者父类的方法对象
     * 而缓存的注解在实现类的方法上
     * 所以应该使用反射获取当前对象的方法对象
     */
    public Method getMethod(ProceedingJoinPoint pjp) {
        //获取参数的类型
        Object[] args = pjp.getArgs();
        Class[] argTypes = new Class[pjp.getArgs().length];
        for (int i = 0; i < args.length; i++) {
            argTypes[i] = args[i].getClass();
        }
        Method method = null;
        try {
            method = pjp.getTarget().getClass().getMethod(pjp.getSignature().getName(), argTypes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return method;

    }

    /**
     * 获取缓存的key
     * key 定义在注解上，支持SPEL表达式
     *
     * @param pjp
     * @return
     */
    private String parseKey(String key, Method method, Object[] args) {

        //获取被拦截方法参数名列表(使用Spring支持类库)
        LocalVariableTableParameterNameDiscoverer u =
                new LocalVariableTableParameterNameDiscoverer();
        String[] paraNameArr = u.getParameterNames(method);

        //使用SPEL进行key的解析
        ExpressionParser parser = new SpelExpressionParser();
        //SPEL上下文
        StandardEvaluationContext context = new StandardEvaluationContext();
        //把方法参数放入SPEL上下文中
        for (int i = 0; i < paraNameArr.length; i++) {
            context.setVariable(paraNameArr[i], args[i]);
        }
        return parser.parseExpression(key).getValue(context, String.class);
    }
}
