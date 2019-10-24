package datastruct;

public class MyArrayTest {
    public static void main(String[] args) {
        MyArray ma = new MyArray();
        System.out.println(ma.elements.length);
        ma.add(5);
        ma.add(7);
        ma.add(9);
        ma.show();
        ma.delete(1);
        ma.show();
        ma.insert(3,8);
        ma.show();
    }
}
