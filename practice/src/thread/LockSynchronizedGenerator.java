package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * author: snows
 * created on: 2018/3/25 2:38
 * description:
 */

public class LockSynchronizedGenerator extends IntGenerator {
    private int num;
    private ReentrantLock rtLock = new ReentrantLock();

    @Override
    protected int next() {
        rtLock.lock();
        System.out.println(Thread.currentThread().getName() + "has locked");
        try {
            ++num;
            Thread.yield();
            ++num;
            return num;
        } finally {
            rtLock.unlock();
            System.out.println(Thread.currentThread().getName() + "has unlocked");
        }
    }
}
