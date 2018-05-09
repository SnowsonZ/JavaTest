package com.snowson.practice.thread.test;

import com.snowson.practice.thread.TaskDebug;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Snowson
 * @Date: 2018/5/2 18:00
 * @Description:
 */
public class ThreadDebugTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executor.submit(new TaskDebug());
        }
        executor.shutdown();
        System.out.println(~0);

    }
}
