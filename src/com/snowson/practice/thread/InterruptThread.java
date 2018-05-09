package com.snowson.practice.thread;

/**
 * @Author: Snowson
 * @Date: 2018/5/9 16:34
 * @Description:
 */
public class InterruptThread extends Thread {
    int index;

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                //调用interrupt时异常，并清除中断状态
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(index++);
        }
    }
}
