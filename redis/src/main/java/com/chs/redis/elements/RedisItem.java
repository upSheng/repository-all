package com.chs.redis.elements;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author : HongSheng.Chen
 * @date : 2020/10/15 16:41
 */
public class RedisItem {

    private String hostName = null;
    private String password = null;
    private Integer port = null;
    private String beanName = null;
    private Class clazz = RedisTemplate.class;
    private Integer database = 0;
    private Integer maxIdle = 5;
    private Integer minIdle = 1;
    private Integer maxActive = 100;
    private Integer maxWait = 5;

    private RedisSerializer keySerializer = new StringRedisSerializer();
    private RedisSerializer hashKeySerializer = new GenericFastJsonRedisSerializer();
    private RedisSerializer hashValueSerializer = new GenericFastJsonRedisSerializer();
    private RedisSerializer valueSerializer = new GenericFastJsonRedisSerializer();

    public RedisItem(RedisInstance redisInstance, String beanName) {
        this.hostName = redisInstance.getHostname();
        this.password = redisInstance.getPassword();
        this.port = redisInstance.getPost();
        this.beanName = beanName;
    }

    public RedisItem() {
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public Integer getDatabase() {
        return database;
    }

    public void setDatabase(Integer database) {
        this.database = database;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }

    public Integer getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }

    public Integer getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(Integer maxWait) {
        this.maxWait = maxWait;
    }

    public RedisSerializer getKeySerializer() {
        return keySerializer;
    }

    public void setKeySerializer(RedisSerializer keySerializer) {
        this.keySerializer = keySerializer;
    }

    public RedisSerializer getHashKeySerializer() {
        return hashKeySerializer;
    }

    public void setHashKeySerializer(RedisSerializer hashKeySerializer) {
        this.hashKeySerializer = hashKeySerializer;
    }

    public RedisSerializer getHashValueSerializer() {
        return hashValueSerializer;
    }

    public void setHashValueSerializer(RedisSerializer hashValueSerializer) {
        this.hashValueSerializer = hashValueSerializer;
    }

    public RedisSerializer getValueSerializer() {
        return valueSerializer;
    }

    public void setValueSerializer(RedisSerializer valueSerializer) {
        this.valueSerializer = valueSerializer;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
