package thread;

public class Thread4Test {
    public static void main(String[] args) {
        Thread4 outClass = new Thread4();
        outClass.new T1().start();
        outClass.new T2().start();
    }
}
