package com.snowson.practice.http;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Author: Snowson
 * @Date: 2018/5/25 16:32
 * @Description:
 */
public class HttpTest {
    public static void main(String[] args) {
        OkHttpClient sClient = HttpClient.getDefault();
        Request request = new Request.Builder()
                .url("")
                .build();
        try {
            Response response = sClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
