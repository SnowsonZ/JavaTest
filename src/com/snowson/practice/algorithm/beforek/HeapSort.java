package com.snowson.practice.algorithm.beforek;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Snowson
 * @Date: 2018/6/7 10:32
 * @Description:
 */
public class HeapSort {
    private List<Integer> data = new ArrayList<Integer>();
    private int length;
    //是否为最大堆
    private boolean isMax;

    public boolean isMax() {
        return isMax;
    }

    public void setMax(boolean max) {
        isMax = max;
    }

    /**
     * 堆初始化，最大堆
     */
    public void initHeap() {
        if (data.size() <= 0) {
            return;
        }
        length = data.size() - 1;
        for (int k = length / 2; k >= 1; k--) {
            if (isMax) {
                sinkByDesc(k);
            } else {
                sinkByAesc(k);
            }
        }
    }

    public void addElement(int index, int elem) {
        data.add(index, elem);
    }

    /**
     * 下沉排序
     *
     * @param k
     */
    private void sinkByDesc(int k) {
        while (2 * k <= length) {
            int child = 2 * k;
            if (child < length && notMore(child, child + 1)) {
                child++;
            }
            if (notMore(child, k)) {
                break;
            } else {
                exchange(child, k);
            }
            k = child;
        }
    }

    private void sinkByAesc(int k) {
        while (2 * k <= length) {
            int child = 2 * k;
            if (child < length && !notMore(child, child + 1)) {
                child++;
            }
            if (!notMore(child, k)) {
                break;
            } else {
                exchange(child, k);
            }
            k = child;
        }
    }


    /**
     * @param cur
     * @param dest
     */
    private void exchange(int cur, int dest) {
        int swap = data.get(cur);
        data.set(cur, data.get(dest));
        data.set(dest, swap);
    }

    private boolean notMore(int cur, int dest) {
        return data.get(cur) <= data.get(dest);
    }

    /**
     * 按顺序输出
     */
    public void printOrder() {
        initHeap();
        while (length > 0) {
            int curMax = delMax();
            System.out.print(curMax + ", ");
        }
    }

    private int delMax() {
        initHeap();
        int max = data.get(1);
        exchange(1, length);
        data.remove(length);
        length--;
        if (isMax) {
            sinkByAesc(1);
        } else {
            sinkByDesc(1);
        }
        return max;
    }

    public void preK(int k) {
        for (int i = 0; i < k; i++) {
            int curMax = delMax();
            System.out.print(curMax + ", ");
        }
    }
}
