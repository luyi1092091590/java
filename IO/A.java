package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class A {
    public static void main(String[] args) throws IOException {
//        InputStream inputStream = new FileInputStream("file.txt");
//        int a;
//        byte[] b = new byte[20];
//        while ((a =inputStream.read()) != -1) {
//            System.out.println(a);
//        }
//        while ((a=inputStream.read())!=-1){
//            System.out.println(a);
//        }
//        while ((a=inputStream.read(b))!=-1){
//            System.out.println(a);
//            System.out.println(Arrays.toString(b));
//            String str = new String(b);
//            System.out.println(str);
//        }
//        String string = "中国";
//        byte[] bytes = string.getBytes();
//        System.out.println(Arrays.toString(bytes));
//        FileReader reader = new FileReader("file.txt");
//        FileWriter writer = new FileWriter("1.txt");
//        while ((a=reader.read())!=-1){
////            System.out.println(a);
//            writer.write(a);
//        }
//        reader.close();
//        Integer integer = new Integer(10);
//        writer.write(integer);
//        writer.close();
//        ArrayList<Integer> list = new ArrayList();
//        list.add(1);
//        list.add(2);
//        System.out.println(list);
//        System.out.println(list.get(1));
//        String a = new String("中");
//        byte[] bytes = a.getBytes();
//        System.out.println(Arrays.toString(bytes));
//        String b = new String(bytes,"iso-8859-1");
//        System.out.println(b);
//        System.out.println(a.equals(b));
//        byte[] bytes1 = b.getBytes();
//        System.out.println(Arrays.toString(bytes1));
//        String c = new String(bytes,"utf-8");
//        System.out.println(b.equals(c));
//        System.out.println(bytes.equals(bytes1));
//        System.out.println("abccd".contains("cb"));
//        String str = "abdef";
//        System.out.println(str.replace("ab","dd"));
//        System.out.println(str);
        RandomAccessFile ras = new RandomAccessFile("1.txt","rw");
        String line = "";
        while ((line=ras.readLine())!=null){
            System.out.println(line.length());
            System.out.println(ras.getFilePointer());
//            System.out.println(new String(line.getBytes("iso-8859-1")));
        }
    }
}
