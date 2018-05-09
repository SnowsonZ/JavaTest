package com.snowson.practice.thread;

/**
 * author: SnowsonZ
 * created on: 2018/5/9 7:42
 * description:
 */

public class ReturnRunnable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            String content = "from runnable";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
