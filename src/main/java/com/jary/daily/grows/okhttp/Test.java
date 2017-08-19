package com.jary.daily.grows.okhttp;

import com.jary.daily.grows.okhttp.HttpClient;
import org.json.JSONObject;

import java.io.IOException;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/8/19 上午10:24
 */
public class Test {

    public static final String URL = "http://localhost:8082/";

    public static final String POSR_URL = "http://10.0.40.91:9092/rpb-internal/api/offline/repayment/getRepaymentAmount";

    public static void main(String[] args) throws IOException {
        String userName = "fanzhengjie";
        int age = 25;

        //GET
        StringBuffer sb = new StringBuffer(URL).append("okHttpGet?userName="+userName).append("&age="+age);
        System.out.println(HttpClient.httpGett(sb.toString()));

        //PSOT （）
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("autoId",0);
        jsonObject.put("isBefore",0);
        jsonObject.put("tenderId",1492715);
        System.out.println(HttpClient.httpPost(POSR_URL,jsonObject.toString()));
    }
}
