package com.hxcf.analysis.tests.service;

import com.hxcf.analysis.config.DefinitionProperties;
import com.hxcf.analysis.service.RedisService;
import com.hxcf.analysis.tests.TestBase;
import org.junit.Test;

import javax.annotation.Resource;

public class TestRedisService extends TestBase {
    @Resource
    private RedisService redisService;
    @Resource
    private DefinitionProperties definitionProperties;

    @Test
    public void testRedisSet() {
        String key = definitionProperties.getCachePrefix() + ":" + "fruit";
        redisService.set(key, "apple");
        print(redisService.get(key));
    }
}
