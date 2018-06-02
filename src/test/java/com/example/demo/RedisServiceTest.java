package com.example.demo;

import com.example.service.RedisService;
import io.lettuce.core.MapScanCursor;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.ScanArgs;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;

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
        RedisURI uri = new RedisURI("192.168.192.39",6379, Duration.ofMillis(3000));
        uri.setPassword("erayt123");
        RedisClient client = RedisClient.create(uri);
        StatefulRedisConnection<String, String> connect = client.connect();

        RedisCommands<String, String> sync = connect.sync();

        ScanArgs args = new ScanArgs();
        args.match("mds_RealTime_PriceEngine_*");
        args.limit(10);

        MapScanCursor<String, String> hscan = sync.hscan("0", args);
//        hscan.


//        redisService.setValue("name", "黄宇");
//        Assert.assertEquals(redisService.get("name"),"黄宇");
    }

}
