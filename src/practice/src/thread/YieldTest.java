package practice.src.thread;

/**
 * author: snows
 * created on: 2018/3/25 3:59
 * description: Thread.yield() **并不一定会让出线程
 */

public class YieldTest {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println(Thread.currentThread().getName() + ": isRunning");
            }
        }.start();
        try {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + ": isRunning");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
