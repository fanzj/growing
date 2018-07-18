package com.jary.daily.grows.okhttp;

import com.alibaba.fastjson.JSONObject;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author fanzhengjie
 * @create 2018/6/14 下午3:25
 * @description
 */
public class URLTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String decodeContent = URLDecoder.decode("%7b%26quot%3buserId%26quot%3b%3a%26quot%3b120296255%26quot%3b%2c%26quot%3bregisterTime%26quot%3b%3a%26quot%3b2018-06-08+11%3a09%3a38%26quot%3b%2c%26quot%3bpartnerUserId%26quot%3b%3a%26quot%3b999817%26quot%3b%2c%26quot%3bregisterState%26quot%3b%3a2%7d","utf-8");
        System.out.println(decodeContent);
        JSONObject jsonObject = JSONObject.parseObject(decodeContent);
        System.out.println(jsonObject);
    }

}
