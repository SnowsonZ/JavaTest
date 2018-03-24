package thread;

/**
 * author: snows
 * created on: 2018/3/25 1:43
 * description:
 */

public class EventChecker implements Runnable {
    private int id;
    private IntGenerator generator;

    public EventChecker(int id, IntGenerator generator) {
        this.id = id;
        this.generator = generator;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": current state: " + generator.isCanceled());
        while (!generator.isCanceled()) {
            int value = generator.next();
            System.out.println(Thread.currentThread().getName() + ": value = " + value);
            if (value % 2 != 0) {
                System.out.println(value + " not even");
                generator.cancel();
            }
        }
    }
}
