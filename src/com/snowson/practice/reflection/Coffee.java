package com.snowson.practice.reflection;

/**
 * author: snows
 * created on: 2018/3/31 21:55
 * description:
 */

public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
