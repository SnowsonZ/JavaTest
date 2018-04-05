package com.snowson.practice.reflection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: snows
 * created on: 2018/3/31 21:49
 * description:
 */

public interface Generator<T> {
    T next();
}

class Test<M> {
    private void test1(Map<Integer, String> map) {
        System.out.println(map.getClass().getName());
    }

    private <K, V> Map<K, V> test2() {
        return new HashMap<>();
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Test test = new Test();
        test.test1(test.<Integer, String>test2());
        Position<Long, Integer> position = new Position<>();
        System.out.println(Arrays.toString(position.getClass().getTypeParameters()));

        Class c1 = new ArrayList<Integer>().getClass();
        Class c2 = new ArrayList<String>().getClass();
        System.out.println(c1 == c2);
    }
}

class Position<MENTION, POSITION> {

}
