package com.jary.daily.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.jary.daily.entity.JacksonIgnoreDO;
import com.jary.daily.utils.StringUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/10/31 下午7:01
 */
public class JsonDemo {

    @Test
    public void readJsonFile() throws IOException {
        StringUtil stringUtil = new StringUtil();
        stringUtil.getFile("config/maintain.json");
    }

    @Test
    public void jsonIgnoreProperties() throws IOException {
        JacksonIgnoreDO jacksonIgnoreDO = new JacksonIgnoreDO();
        jacksonIgnoreDO.setId(111);
        jacksonIgnoreDO.setName("myName");
        jacksonIgnoreDO.setAge(22);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(jacksonIgnoreDO);
        //System.out.println(jsonStr);
        Assert.assertEquals("{\"id\":111}",jsonStr);//name和age被忽略掉了

        String jsonStr2 = "{\"id\":111,\"name\":\"myName\",\"age\":22,\"title\":\"myTitle\"}";
        JacksonIgnoreDO jacksonIgnoreDO2 = objectMapper.readValue(jsonStr2,JacksonIgnoreDO.class);
        Assert.assertEquals(111,jacksonIgnoreDO2.getId());
        Assert.assertNull(jacksonIgnoreDO2.getName());
        Assert.assertEquals(0,jacksonIgnoreDO2.getAge());

        String jsonStr3 = "{\"id\":111,\"name\":\"myName\",\"count\":33}";//这里有个未知的count属性，反序列化会报错
        objectMapper.readValue(jsonStr3, JacksonIgnoreDO.class);
    }
}
