package thread;

/**
 * 四个线程按顺序执行
 * */

public class Thread6 {
    static int i = 0;
    static int count = 0;
    static Object lock = new Object();
//    public String name;

    class Ta extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (count % 4 == 0) {
                        i++;
                        System.out.println(getName() + ":i=" + i);
                        count++;
                    } else {
                        lock.notifyAll();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    class Tb extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (count % 4 == 1) {
                        i++;
                        System.out.println(getName() + ":i=" + i);
                        count++;
                    } else {
                        lock.notifyAll();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    class Tc extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (count % 4 == 2) {
                        i--;
                        System.out.println(getName() + ":i=" + i);
                        count++;
                    } else {
                        lock.notifyAll();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    class Td extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (count % 4 == 3) {
                        i--;
                        System.out.println(getName() + ":i=" + i);
                        count++;
                        System.out.println("------------------------------------");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        lock.notifyAll();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
