package com.learning.redisexample.service;

import lombok.RequiredArgsConstructor;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedissonClient redissonClient;

    public <T> void update(String key, T value) {
         RBucket<T> bucket = redissonClient.getBucket(key);
         bucket.set(value);
    }

    public <T> T getByKey(String key) {
        RBucket<T> bucket = redissonClient.getBucket(key);
        return bucket.get();
    }

    public <T> boolean deleteByKey(String key) {
        RBucket<T> bucket = redissonClient.getBucket(key);
        return bucket.delete();
    }


}
