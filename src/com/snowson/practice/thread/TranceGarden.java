package com.snowson.practice.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * author: snows
 * created on: 2018/3/28 7:41
 * description:
 */

public class TranceGarden {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            es.execute(new Entrance(i));
        }
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        es.shutdown();
        if (!es.awaitTermination(250, TimeUnit.MILLISECONDS)) {
            System.out.println("Some task were not terminated");
        }
        System.out.println("Total: " + Entrance.getTotalCount());
        System.out.println("entrances: " + Entrance.sumEntrances());
    }
}

class Count {
    private int count = 0;
    private Random random = new Random(47);

    public synchronized int increment() {
        int temp = count;
        if (random.nextBoolean()) {
            Thread.yield();
        }
        return count = ++temp;
    }

    public synchronized int value() {
        return count;
    }
}

class Entrance implements Runnable {

    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<>();
    private int number = 0;
    private final int id;
    private static volatile boolean canceld = false;

    public static void cancel() {
        canceld = true;
    }

    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }

    @Override
    public void run() {
        while (!canceld) {
            synchronized (this) {
                ++number;
            }
            System.out.println(this + " Total: " + count.increment());
            try {
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }
            System.out.println("stopping " + this);
        }
    }

    public synchronized int getValue() {
        return number;
    }

    @Override
    public String toString() {
        return "Entrance " + id + " : " + getValue();
    }

    public static int getTotalCount() {
        return count.value();
    }

    public static int sumEntrances() {
        int sum = 0;
        for (Entrance item : entrances) {
            sum += item.getValue();
        }
        return sum;
    }
}
