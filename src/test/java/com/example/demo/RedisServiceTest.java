package com.example.demo;

import com.example.service.RedisService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2018/4/15 23:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest {

    @Autowired
    RedisService redisService;


    @Test
    public void redisServiceTest() {
        redisService.setValue("name", "黄宇");
        Assert.assertEquals(redisService.get("name"),"黄宇");
    }

}
