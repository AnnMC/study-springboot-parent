package study.springboot.all.study.springboot.all.cachelock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Component;
import study.springboot.all.study.springboot.all.exception.BizException;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * 分布式锁
 */
@Component
public class LockService {
    private Logger logger = LoggerFactory.getLogger(LockService.class);
    /**
     * 默认为一秒
     */
    private Long expire = 10L;
    /**
     * 时间处理
     */
    private TimeUnit timeUnit = TimeUnit.SECONDS; // 秒
    /**
     * 分隔符
     */
    private static final String DELIMITER = "|";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void lock(String key) {
        // 值
        final String value = key + DELIMITER + System.currentTimeMillis() + Expiration.from(expire, timeUnit).getExpirationTimeInMilliseconds();
        Boolean success = redisTemplate.opsForValue().setIfAbsent(key, value);
        if (success) {
            redisTemplate.expire(key, expire, timeUnit);
        } else {
            String oldVal = redisTemplate.opsForValue().getAndSet(key, value);
            final String[] oldValues = oldVal.split(Pattern.quote(DELIMITER));
            logger.info("当前Redis数据库值:" + oldValues[1]);
            if (Long.parseLong(oldValues[1]) > System.currentTimeMillis()) {
                throw new BizException("你点的太快了");
            }
        }
    }
}
