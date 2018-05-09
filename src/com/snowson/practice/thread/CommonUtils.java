package com.snowson.practice.thread;

/**
 * @Author: Snowson
 * @Date: 2018/5/9 12:15
 * @Description:
 */
public class CommonUtils {
    public static CommonUtils instance;

    public static CommonUtils getInstance() {
        if (instance == null) {
            synchronized (CommonUtils.class) {
                if (instance == null) {
                    instance = new CommonUtils();
                }
            }
        }
        return instance;
    }

    /**
     * wait thread
     */
    public synchronized void getCartInfo() {
        for (int i = 0; i < 20; i++) {
            try {
                if (i % 3 == 0) {
                    System.out.println(Thread.currentThread().getName() + " wait : " + i);
//                    Thread.sleep(500);
                    wait(2000);
                }
                if (i % 12 == 0) {
                    System.out.println(Thread.currentThread().getName() + " notify : " + i);
                    notify();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * join thread
     */
    public synchronized void getGoodsInfo() {
        for (int i = 0; i < 100; i++) {
            if (i % 111 == 0) {
                System.out.println(i);
                Thread thread = new Thread(new NormalRunnable());
                thread.start();
                try {
                    thread.join();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
