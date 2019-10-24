package thread;


import java.util.Random;
/**
 * 两个线程，按顺序执行，第一个先输出1-52的数字，第二个输出大写字母
 * */

public class Thread5 {
    static String flag;

    class Th1 extends Thread {
        @Override
        public void run() {
            Random random = new Random();
            while (true) {
                synchronized (String.class) {
                    if (flag == null) {
                        System.out.print(random.nextInt(52) + 1);
                        flag = "";
                        String.class.notify();
                        try {
                            String.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        String.class.notify();
                        try {
                            String.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


    class Th2 extends Thread {
        @Override
        public void run() {
            Random random = new Random();
//            System.out.println(Thread.currentThread().getName());
            while (true) {
                synchronized (String.class) {
                    if (flag == null) {
                        String.class.notify();
                        try {
                            String.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println((char) (random.nextInt(26) + 65));
                    flag = null;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}