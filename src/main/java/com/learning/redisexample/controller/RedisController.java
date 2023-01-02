package com.learning.redisexample.controller;

import com.learning.redisexample.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/redis")
@RequiredArgsConstructor
public class RedisController {

    private final RedisService redisService;

    @PutMapping
    public <T> void update(@RequestParam String key,
                     @RequestParam T value) {
        redisService.update(key, value);
    }

    @GetMapping
    public <T> T getByKey(@RequestParam String key) {
        return redisService.getByKey(key);
    }

    @DeleteMapping
    public boolean deleteByKey(@RequestParam String key) {
        return redisService.deleteByKey(key);
    }

}
