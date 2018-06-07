package com.snowson.practice.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * @Author: Snowson
 * @Date: 2018/5/25 16:25
 * @Description:
 */
public class HttpClient {
    public static OkHttpClient instance = null;

    public static OkHttpClient getDefault() {
        if (instance == null) {
            synchronized (HttpClient.class) {
                if (instance == null) {
                    instance = new OkHttpClient().newBuilder()
                            .readTimeout(5000, TimeUnit.MILLISECONDS)
                            .writeTimeout(5000, TimeUnit.MILLISECONDS)
                            .build();
                }
            }
        }
        return instance;
    }

    public static OkHttpClient getCoustom(OkHttpClient.Builder builder) {
        instance = builder.build();
        return instance;
    }
}
