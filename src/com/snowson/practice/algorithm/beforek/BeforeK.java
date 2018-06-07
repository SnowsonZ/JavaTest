package com.snowson.practice.algorithm.beforek;

/**
 * @Author: Snowson
 * @Date: 2018/6/6 11:56
 * @Description:
 */
public class BeforeK {
    public static void main(String[] args) {
        HeapSort heap = new HeapSort();
        heap.addElement(0, 0);
        for (int i = 0; i < 10; i++) {
            int v = (int) (Math.random() * 100);
            heap.addElement(i + 1, v);
        }
        heap.setMax(true);
        heap.printOrder();
        //取前K个最大的数
//        heap.preK(6);
    }
}
