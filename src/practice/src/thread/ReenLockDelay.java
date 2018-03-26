package practice.src.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: snows
 * created on: 2018/3/25 3:11
 * description:
 */

public class ReenLockDelay {
    private ReentrantLock rtl = new ReentrantLock();

    private void unTimed() {
        boolean capture = rtl.tryLock();
        try {
            System.out.println("unTimed: tryLock() capture: " + capture);
        } finally {
            if (capture) {
                rtl.unlock();
                System.out.println("unTimed unLock");
            }
        }
    }

    private void timed() {
        boolean capture;
        try {
            capture = rtl.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " + capture);
        } finally {
            if (capture) {
                rtl.unlock();
                System.out.println("timed unLock");
            }
        }
    }

    public static void main(String[] args) {
        ReenLockDelay rld = new ReenLockDelay();
        rld.unTimed();
        rld.timed();
        new Thread() {
            {
                setDaemon(true);
            }

            @Override
            public void run() {
//                super.run();
                rld.rtl.lock();
                System.out.println("new Task lock");
            }
        }.start();
        //使用yield无法是main线程让步，使用sleep
//        Thread.yield();
        try {
            Thread.sleep(1);
            rld.unTimed();
            rld.timed();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
