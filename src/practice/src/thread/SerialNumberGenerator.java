package practice.src.thread;

public class SerialNumberGenerator {
    private static volatile int serialNum;
    public static int nextSerialNum() {
        return serialNum++;
    }
}
