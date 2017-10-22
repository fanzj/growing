package com.jary.daily.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.net.URL;
import java.util.List;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/10/22 下午7:10
 */
public class RedisTest {

    @Autowired
    private RedisTemplate<String,String> template;

    @Resource(name = "redisTemplate")
    private ListOperations<String,String> listOps;

    public void addLink(String userId, URL url){
        listOps.leftPush(userId,url.toExternalForm());
        template.boundListOps(userId).leftPush(url.toExternalForm());
    }


}
