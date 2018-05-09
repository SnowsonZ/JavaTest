package com.snowson.practice.thread;

import java.util.concurrent.Callable;

/**
 * author: SnowsonZ
 * created on: 2018/5/9 6:52
 * description:
 */

public class ReturnThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        String result = "complete...";
        Thread.sleep(2000);
        return result;
    }
}

