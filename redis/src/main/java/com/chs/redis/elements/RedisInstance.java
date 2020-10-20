package com.chs.redis.elements;

/**
 * @author : HongSheng.Chen
 * @date : 2020/10/15 15:00
 */
public enum RedisInstance {
    REDIS_LOCAL("localhost", null, 6379),
    REDIS_TEST("onetu.top", null, 6379);

    String hostname;
    String password;
    Integer post;

    public String getHostname() {
        return hostname;
    }

    public String getPassword() {
        return password;
    }

    public Integer getPost() {
        return post;
    }

    RedisInstance(String hostname, String password, Integer port) {
        this.hostname = hostname;
        this.password = password;
        this.post = port;
    }
}
