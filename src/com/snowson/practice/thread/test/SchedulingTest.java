package com.snowson.practice.thread.test;

import com.snowson.practice.thread.InterruptThread;

/**
 * @Author: Snowson
 * @Date: 2018/5/9 14:25
 * @Description:
 */
public class SchedulingTest {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newCachedThreadPool();

        //wait
//        executorService.submit(new SleepThread());
//        executorService.submit(new NormalRunnable());
//        executorService.submit(new SleepThread());
//        executorService.submit(new NormalRunnable());

        // join
//        executorService.submit(new JoinThread());

//        executorService.shutdown();

        //interrupt
        Thread thread = new InterruptThread();
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
