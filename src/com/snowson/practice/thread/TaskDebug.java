package com.snowson.practice.thread;

/**
 * @Author: Snowson
 * @Date: 2018/5/2 17:53
 * @Description:
 */
public class TaskDebug implements Runnable {
    @Override
    public void run() {
        System.out.println("TaskDebug start ....");
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
        System.out.println("TaskDebug stop ....");
    }
}
