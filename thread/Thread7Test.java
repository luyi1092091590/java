package thread;


import java.util.ArrayList;

public class Thread7Test {
    public static void main(String[] args) {
//        Thread7 thread7 = new Thread7();
//        Thread t1 = new Thread(thread7);
//        t1.setName("11111");
//        t1.start();
//        Thread t2 = new Thread(thread7);
//        t2.setName("2222");
//        t2.start();

//        new Thread7("抽奖箱1").start();
//        new Thread7("抽奖箱22222222222222222").start();
        new ThreadSum("thread1").start();
        new ThreadSum("thread2222222222222").start();
    }
}
