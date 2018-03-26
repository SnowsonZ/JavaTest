package practice.src.thread;

import thread.IntGenerator;

/**
 * author: snows
 * created on: 2018/3/25 1:22
 * description:
 */

public class EventGenerator extends IntGenerator {
    private int num = 0;

    @Override
    protected synchronized int next() {
        ++num;
        Thread.yield();
        ++num;
        return num;
    }
}
