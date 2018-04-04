package com.jary.daily.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.jary.daily.entity.JacksonIgnoreDO;
import com.jary.daily.utils.StringUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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

    @Test
    public void testJson() throws JSONException {
        /*JSONObject jsonObject = new JSONObject();
        jsonObject.put("autoId",0);
        jsonObject.put("isBefore",0);
        jsonObject.put("tenderId",1492715);
        System.out.println(jsonObject);*/

        JSONArray data = new JSONArray();

        JSONObject stu1 = new JSONObject();
        stu1.put("name", "Jack");
        stu1.put("age",20);
        stu1.put("sex","男");
        data.put(stu1);

        JSONObject stu2 = new JSONObject();
        stu2.put("name", "Rose");
        stu2.put("age",18);
        stu2.put("sex","女");
        data.put(stu2);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",data);
        System.out.println(jsonObject);
    }

}
