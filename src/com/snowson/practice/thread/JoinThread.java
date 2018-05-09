package com.snowson.practice.thread;

/**
 * @Author: Snowson
 * @Date: 2018/5/9 15:49
 * @Description:
 */
public class JoinThread implements Runnable {

    @Override
    public void run() {
        System.out.println("JoinThread" + Thread.currentThread().getName() + " start");
        CommonUtils instance = CommonUtils.getInstance();
        instance.getGoodsInfo();
        System.out.println("JoinThread" + Thread.currentThread().getName() + " end");
    }
}
