package com.study.springboot.redis;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * 排行榜处理
 */
@Service(value = "rangeManager")
public class RangeManager {
    public String[] arr = new String[]
            {"tom", "andy", "limei", "tt", "xx", "ff",
                    "zhangsan", "lisi", "nn", "linlin",
                    "ww", "xx", "yy", "qq"};
    private String juediqiusheng_key = "juediqiusheng";

    /**
     * 初始化排行榜
     *
     * @return
     */
    public boolean initRange() {
        RedisUtilPool pool = new RedisUtilPool();
        Jedis jedis = pool.getJedis();
        //初始化为零
        for (int i = 0; i < arr.length; i++) {
            jedis.zadd(juediqiusheng_key, 0, arr[i]);
        }

        for (int i = 0; i < 100000; i++) {
            Integer count = RandomUtils.nextInt(0, arr.length);
            jedis.zincrby(juediqiusheng_key, 1, arr[count]);
        }
        return Boolean.TRUE;
    }

    /**
     * 获取前传入参数的排名
     *
     * @return
     */
    public Set<String> getRange(Integer index) {
        RedisUtilPool pool = new RedisUtilPool();
        Jedis jedis = pool.getJedis();
        Set<String> set = jedis.zrevrange(juediqiusheng_key, 0, index);
        return set;
    }
}
