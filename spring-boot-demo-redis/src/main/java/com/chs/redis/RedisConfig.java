package com.chs.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2019/9/12<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2019/9/12            创建
 * --------------------------------------------------------------------
 * </pre>
 */

@Configuration
public class RedisConfig {

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {

        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("127.0.0.1", 6379);
        return new JedisConnectionFactory(config);
    }



}
