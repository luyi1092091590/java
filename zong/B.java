package zong;

import java.util.ArrayList;

public class B {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String a = "Aa";
        sb.insert(0, a);
//        System.out.println(sb);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
        StringBuilder s = new StringBuilder(sb);
        System.out.println(s);
        System.out.println(Integer.toBinaryString(-1));
        String str = "10000000";
        System.out.println(str.length());
        System.out.println((byte) Integer.parseInt(str, 2));
        System.out.println("===================");
        f(num);
        System.out.println("sadfsaf" + num);
    }

    static int num;

    public static void f(int n) {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            num++;
        }
    }
}
