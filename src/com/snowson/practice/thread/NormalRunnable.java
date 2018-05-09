package com.snowson.practice.thread;

/**
 * @Author: Snowson
 * @Date: 2018/5/9 14:26
 * @Description:
 */
public class NormalRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(NormalRunnable.this.getClass().getName() + " Normal start");
        CommonUtils instance = CommonUtils.getInstance();
        //测试join
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //测试wait
        instance.getCartInfo();
        System.out.println(NormalRunnable.this.getClass().getName() + " Normal end");
    }
}
