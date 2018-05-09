package com.snowson.practice.attributes.anonymous;

/**
 * author: SnowsonZ
 * created on: 2018/4/23 23:58
 * description:
 */

public class AnonymousTest {
    public void useAnonymous() {
        int num = 123;

        MyInterface myInterface = new MyInterface() {
            @Override
            public void doSomeThing() {
                System.out.println(num);
            }
        };
        myInterface.doSomeThing();
        System.out.println(num);
    }
}
