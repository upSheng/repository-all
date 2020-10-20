package com.chs.redis.elements;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.*;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2020/10/15 15:06
 */

public class RedisRegister implements BeanDefinitionRegistryPostProcessor {


    private ScopeMetadataResolver scopeMetadataResolver = new AnnotationScopeMetadataResolver();
    private BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();
    private List<RedisItem> redisItemList = new ArrayList<>();

    public RedisRegister(List<RedisItem> redisItemList) {

        this.redisItemList = redisItemList;
    }


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {


        for (RedisItem redisItem : redisItemList) {
            BeanDefinition bd = beanFactory.getBeanDefinition(redisItem.getBeanName());
            MutablePropertyValues mpv = bd.getPropertyValues();

            RedisConnectionFactory redisConnectionFactory = connectionFactory(
                    redisItem.getHostName(),
                    redisItem.getPort(),
                    redisItem.getPassword(),
                    redisItem.getMaxIdle(),
                    redisItem.getMinIdle(),
                    redisItem.getDatabase(),
                    redisItem.getMaxActive(),
                    redisItem.getMaxWait());
            mpv.add("connectionFactory", redisConnectionFactory);
            if (redisItem.getKeySerializer() != null) {
                mpv.add("keySerializer", redisItem.getKeySerializer());
                mpv.add("hashKeySerializer", redisItem.getHashValueSerializer());
            }
            if (redisItem.getValueSerializer() != null) {
                mpv.add("valueSerializer", redisItem.getValueSerializer());
                mpv.add("hashValueSerializer", redisItem.getHashValueSerializer());
            }
        }


    }

    public static RedisConnectionFactory connectionFactory(String hostName, int port,
                                                           String password, int maxIdle, int minIdle, int index,
                                                           int maxActive, int maxWait) {
        JedisConnectionFactory jedis = new JedisConnectionFactory();
        jedis.setHostName(hostName);
        jedis.setPort(port);
        if (!StringUtils.isEmpty(password)) {
            jedis.setPassword(password);
        }
        if (index != 0) {
            jedis.setDatabase(index);
        }
        jedis.setPoolConfig(poolConfig(maxIdle, minIdle,
                maxWait, maxActive));
        jedis.afterPropertiesSet();
        RedisConnectionFactory factory = jedis;
        return factory;
    }

    public static JedisPoolConfig poolConfig(int maxIdle, int minIdle, int maxWait, int maxTotal) {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setMaxWaitMillis(maxWait);

        return poolConfig;
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        for (RedisItem redisItem : redisItemList) {
            registerBean(registry, redisItem.getBeanName(), redisItem.getClazz());
        }
    }

    private void registerBean(BeanDefinitionRegistry registry, String name, Class<?> beanClass) {
        AnnotatedGenericBeanDefinition abd = new AnnotatedGenericBeanDefinition(beanClass);
        ScopeMetadata scopeMetadata = this.scopeMetadataResolver.resolveScopeMetadata(abd);
        abd.setScope(scopeMetadata.getScopeName());
        String beanName = (name != null ? name : this.beanNameGenerator.generateBeanName(abd, registry));
        AnnotationConfigUtils.processCommonDefinitionAnnotations(abd);
        BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(abd, beanName);
        BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, registry);
    }
}
