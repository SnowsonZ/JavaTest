package practice.src.thread;

public class SerialNumberSet {
    private int[] array;
    private int len;
    private int index;

    public SerialNumberSet(int size) {
        array = new int[size];
        len = size;
        for (int i = 0; i < len; i++) {
            array[i] = -1;
        }
    }

    public synchronized void add(int content) {
        array[index++ % len] = content;
    }

    public synchronized boolean contains(int content) {
        for (int i : array) {
            if (i == content) {
                return true;
            }
        }
        return false;
    }

}
