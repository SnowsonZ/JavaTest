package com.snowson.practice.thread;

/**
 * @Author: Snowson
 * @Date: 2018/5/9 11:54
 * @Description:
 */
public class SleepThread implements Runnable {
    @Override
    public void run() {
        System.out.println("SleepThread " + Thread.currentThread().getName() + " start");
        CommonUtils instance = CommonUtils.getInstance();
        instance.getCartInfo();
        System.out.println("SleepThread end");
    }
}
