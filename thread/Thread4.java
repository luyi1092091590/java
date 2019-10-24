package thread;

import java.math.BigDecimal;

public class Thread4 {
    static double x = 0;

    class T1 extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行线程1，x=" + (x+=1.0));
            }
        }
    }

    class T2 extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行线程2，x=" + (x+=0.1));
            }
        }
    }
}
