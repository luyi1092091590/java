package datastruct;

public class Recursion {
    public static void main(String[] args) {
        // 1 1 2 3 5 8 13
//        System.out.println(febonacci(5));
        febonacci(4);
    }

    public static int febonacci(int i) {
        if (i == 1 || i == 2) {
//            System.out.print(1 + " ");
            return 1;
        } else {
//            System.out.println(febonacci(i - 1) + febonacci(i - 2));
            System.out.println(i);
            return febonacci(i - 1) + febonacci(i - 2);
        }
    }
}
