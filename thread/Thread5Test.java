package thread;

public class Thread5Test {
    public static void main(String[] args) throws InterruptedException {
        Thread5 outclass = new Thread5();
        Thread5.Th1 thread1 = outclass.new Th1();
        Thread5.Th2 thread2 = outclass.new Th2();
        thread1.start();
        thread2.start();
    }
}
