package practice.src.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * author: snows
 * created on: 2018/3/28 7:02
 * description: ThreadLocal是线程安全的，因此所有操作无需同步
 */

public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
        private Random rand = new Random(47);

        @Override
        protected synchronized Integer initialValue() {
            return rand.nextInt(10000);
        }
    };

    public static void increment() {
        value.set(value.get() + 1);
    }

    public static int get() {
        return value.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            es.execute(new Accessor(i));
        }
        TimeUnit.SECONDS.sleep(3000);
        es.shutdown();
    }
}

class Accessor implements Runnable {

    private final int id;

    public Accessor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    @Override
    public String toString() {
        return "#" + id + ":" + ThreadLocalVariableHolder.get();
    }
}
