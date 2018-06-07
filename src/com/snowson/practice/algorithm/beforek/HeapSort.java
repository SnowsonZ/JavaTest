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
    //是否为下沉排序
    private boolean isSink;

    public boolean isSink() {
        return isSink;
    }

    public void setSink(boolean sink) {
        isSink = sink;
    }

    public boolean isMax() {
        return isMax;
    }

    public void setMax(boolean max) {
        isMax = max;
    }

    /**
     * 堆初始化，最大堆
     */
    public void initHeapSink() {
        if (data.size() <= 0) {
            return;
        }
        length = data.size() - 1;
        for (int k = length / 2; k >= 1; k--) {
            //下沉实现根的初始化，时间复杂度：·
            if (isMax) {
                sinkByDesc(k);
            } else {
                sinkByAesc(k);
            }
        }
    }

    public void initHeapSwim() {
        if (data.size() <= 0) {
            return;
        }
        length = data.size() - 1;
        //上浮实现堆初始化 时间复杂度 O(nlogn)
        for (int k = length; k >= 1; k--) {
            swim(k);
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
            //获得子树
            int child = 2 * k;
            //若存在右子节点且右子节点大于左子节点
            if (child < length && notMore(child, child + 1)) {
                child++;
            }
            //比较子节点与父节点大小
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
        if (isSink) {
            initHeapSink();
        } else {
            initHeapSwim();
        }
        while (length > 0) {
            int curMax = delMax();
            System.out.print(curMax + ", ");
        }
    }

    /**
     * 从堆中找出当前最大值并恢复堆排序
     *
     * @return
     */
    private int delMax() {
        if (isSink) {
            initHeapSink();
        } else {
            initHeapSwim();
        }
        int max = data.get(1);
        exchange(1, length);
        data.remove(length);
        length--;
        if (isSink) {
            if (isMax) {
                sinkByAesc(1);
            } else {
                sinkByDesc(1);
            }
        } else {
            swim(1);
        }
        return max;
    }

    /**
     * 上浮排序
     *
     * @return
     */
    private void swim(int k) {
        //循环结束条件： 根节点已完成检测
        while (k / 2 >= 1) {
            int parent = k / 2;
            if (isMax) {
                if (notMore(k, parent)) {
                    break;
                } else {
                    exchange(k, parent);
                    k = k / 2;
                }
            } else {
                if (notMore(k, parent)) {
                    exchange(k, parent);
                    k = k / 2;
                } else {
                    break;
                }
            }
        }
    }

    //查找前K大数
    public void preK(int k) {
        for (int i = 0; i < k; i++) {
            int curMax = delMax();
            System.out.print(curMax + ", ");
        }
    }
}
