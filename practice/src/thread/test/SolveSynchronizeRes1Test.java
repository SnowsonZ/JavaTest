package thread.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import thread.EventChecker;
import thread.EventGenerator;

/**
 * author: snows
 * created on: 2018/3/25 0:59
 * description:
 */

public class SolveSynchronizeRes1Test {
    public static void main(String[] args) {
        System.out.println("start check...");
        System.out.println("please input control-C to exit...");
        EventGenerator eg = new EventGenerator();
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            es.execute(new EventChecker(i, eg));
        }
        es.shutdown();
    }
}
