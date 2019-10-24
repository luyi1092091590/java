package thread;

public class ThreadSum extends Thread {
    static Integer num = 10000;

    public ThreadSum(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("这是线程"+getName());
        synchronized (num.getClass()) {
            for (; num > 0; num--) {
                System.out.println(getName() + ":" + num);
            }
        }
    }
}
