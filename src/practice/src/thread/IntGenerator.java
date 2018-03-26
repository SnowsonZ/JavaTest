package practice.src.thread;

/**
 * author: snows
 * created on: 2018/3/25 1:16
 * description: 数据生成器
 * 1. 生成数据
 * 2. 当前状态，是否已被取消
 */

public abstract class IntGenerator {
    private boolean isCancled;

    protected void cancel() {
        isCancled = true;
    }

    protected boolean isCanceled() {
        return isCancled;
    }

    protected abstract int next();
}
