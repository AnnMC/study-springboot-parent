package com.study.springboot.cache;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Component
public class RedisCacheBean {

    //注入spring-redis配置好的bean，也可以在配置文件中定义这个RedisCacheBean，里面有一个属性jedisPool，并且属性有get set操作
    @Resource
    ShardedJedisPool jedisPool;

    //private ShardedJedis jedis = jedisPool.getResource();

    /**
     * 把对象放入Hash中
     */
    public void hset(String key, String field, Object o) {
        ShardedJedis jedis = jedisPool.getResource();
        jedis.hset(key, field, JSONArray.toJSONString(o));
        jedisPool.returnResource(jedis);
    }

    /**
     * 从Hash中获取对象
     */
    public String hget(String key, String field) {
        ShardedJedis jedis = jedisPool.getResource();
        String text = jedis.hget(key, field);
        jedisPool.returnResource(jedis);
        return text;
    }

    /**
     * 从Hash中获取对象,转换成制定类型
     */
    public <T> T hget(String key, String field, Class<T> clazz) {
        String text = hget(key, field);
        T result = JSONArray.parseObject(text, clazz);
        return result;
    }

    /**
     * 从Hash中删除对象
     */
    public void hdel(String key, String... field) {
        ShardedJedis jedis = jedisPool.getResource();
        Object result = jedis.hdel(key, field);
        jedisPool.returnResource(jedis);
    }

}
