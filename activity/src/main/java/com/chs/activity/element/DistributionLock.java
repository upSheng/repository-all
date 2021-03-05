package com.chs.activity.element;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/5 15:40
 */
@Component
public class DistributionLock {

    private static final String LOCK_PREFIX = "redisLock";
    private static final Long DEFAULT_EXPIRE_TIME = 5000L;
    private static final Long DEFAULT_TRY_LOCK_TIME = 500L;
    @Resource
    RedissonClient redissonClient;

    public boolean tryLock(String key, Long tryLockTime, Long expireTime) {

        RLock lock = redissonClient.getLock(buildKey(key));
        boolean hasLock = false;
        try {
            hasLock = lock.tryLock(tryLockTime, expireTime, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return hasLock;
    }

    public boolean tryLock(String key) {
        return tryLock(key, DEFAULT_TRY_LOCK_TIME, DEFAULT_EXPIRE_TIME);
    }

    public void unlock(String key) {
        RLock lock = redissonClient.getLock(buildKey(key));
        if (lock.isLocked()) {
            lock.unlock();
        }

    }

    private String buildKey(String key) {
        return String.format("%s:%s", LOCK_PREFIX, key);
    }
}
