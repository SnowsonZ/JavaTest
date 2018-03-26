package practice.src.thread;

public class SerialNumberChecker implements Runnable {
    private SerialNumberSet sns;
//    private

    public SerialNumberChecker(int size) {
        sns = new SerialNumberSet(size);
    }

    @Override
    public void run() {
        while (true) {
            int cotent = SerialNumberGenerator.nextSerialNum();
            if(!sns.contains(cotent)) {
//                sns.add();
            }
        }
    }
}
