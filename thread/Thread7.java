package thread;

import java.util.ArrayList;
import java.util.Random;

public class Thread7 extends Thread {
    //    static int[] arr = {10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300};
    static int[] arr = new int[100];
    static ArrayList<Integer> list = new ArrayList<>();
    static Integer i  = 100;
    static {
        for (int num : arr) {
            list.add(num);
        }
    }

    public Thread7() {
    }

    public Thread7(String name) {
        super(name);
    }

    @Override
    public void run() {
        Random random = new Random();
        int index;

        synchronized (i) {
//            for (;i>1;i--){
//                System.out.println(getName()+":"+i);
//                index = random.nextInt(list.size());
//                System.out.println(getName() + ":" + list.get(index));
//                list.remove(index);
//            }
            while (true) {
                if (list.size() == 0) {
                    break;
                }
//                System.out.println("daxiao" + list.size());
                index = random.nextInt(list.size());
                System.out.println(Thread.currentThread().getName() + ":" + list.get(index));
                list.remove(index);
            }
        }
    }
}
