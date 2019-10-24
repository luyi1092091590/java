package IO;

import java.io.*;
import java.util.ArrayList;

/**
 * 行倒序
 * */

public class IO1 {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<ArrayList> list2 = new ArrayList<>();
        FileReader reader = new FileReader("IO作业一.txt");
//        FileInputStream reader = new FileInputStream("IO作业一.txt");
        int a;
        while ((a=reader.read())!=-1){
            list1.add(a);
            if (a=='\n'){
                System.out.println(copyArraylist(list1));
                //这里需要深复制，如果浅复制后面clear()会清空add到list2中的list1
                list2.add(copyArraylist(list1));
                list1.clear();
                System.out.println(list2);
            }
        }
        list2.add(list1);
        System.out.println(list2);
        FileWriter writer = new FileWriter("IO.txt");
//        FileOutputStream writer = new FileOutputStream("IO.txt");
        for (int i=list2.size()-1;i>=0;i--){
            for (int j=0;j<list2.get(i).size();j++){
//                System.out.println((char)((int)(list2.get(i).get(j))));
                writer.write((int) (list2.get(i).get(j)));
            }
        }
        reader.close();
        writer.close();
    }
    static ArrayList copyArraylist(ArrayList list){
        return new ArrayList(list);
    }
}
