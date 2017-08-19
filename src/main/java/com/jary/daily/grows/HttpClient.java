package com.jary.daily.grows;

import okhttp3.*;

import java.io.IOException;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/8/19 上午9:37
 */
public class HttpClient {

    public static final MediaType JSON = MediaType.parse("application/json;charset=utf-8");

    private static OkHttpClient client = new OkHttpClient();

    public static String httpGett(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String httpPost(String url, String json) throws IOException {
        RequestBody requestBody = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }


}
