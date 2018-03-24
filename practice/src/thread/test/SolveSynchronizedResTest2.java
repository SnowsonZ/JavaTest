package thread.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import thread.EventChecker;
import thread.LockSynchronizedGenerator;

/**
 * author: snows
 * created on: 2018/3/25 2:44
 * description:
 */

public class SolveSynchronizedResTest2 {
    public static void main(String[] args) {
        System.out.println("start check...");
        LockSynchronizedGenerator lsg = new LockSynchronizedGenerator();
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            es.execute(new EventChecker(i, lsg));
        }
        es.shutdown();
    }
}
