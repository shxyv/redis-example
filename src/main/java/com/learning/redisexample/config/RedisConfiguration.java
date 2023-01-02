package com.learning.redisexample.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.SerializationCodec;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class RedisConfiguration {

    @Profile("local")
    @Bean
    public RedissonClient redissonClient(@Value("${redis.server.host}") String host) {
        Config config = new Config();

        config.setCodec(new SerializationCodec());

        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setConnectionPoolSize(4);
        singleServerConfig.setConnectionMinimumIdleSize(2);
        singleServerConfig.setAddress(host);

        return Redisson.create(config);
    }

}
