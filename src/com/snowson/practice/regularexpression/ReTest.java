package com.snowson.practice.regularexpression;

/**
 * @Author: Snowson
 * @Date: 2018/4/27 21:06
 * @Description:
 */
public class ReTest {
    public static void main(String[] args) {
        String content = "32.42*323.1";
        String[] split = content.split("\\*");
        for (String s : split) {
            System.out.println(s);
        }
    }
}
