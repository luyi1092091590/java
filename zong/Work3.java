package zong;

import java.io.RandomAccessFile;

public class Work3 {
    public static void main(String[] args) throws Exception {
//        smallLetter();
        //从q开始
        bigLetter();
    }

    public static void smallLetter() throws Exception {
        RandomAccessFile ras = new RandomAccessFile("letter.txt", "rw");
        for (char letter='a';letter<='z';letter++) {
            ras.write((Character.toString(letter)).getBytes());
        }
        ras.close();
    }
    public static void bigLetter() throws Exception{
        RandomAccessFile ras = new RandomAccessFile("letter.txt", "rw");
        ras.seek(ras.length()-10);
        for (char letter='Q';letter<='Z';letter++){
            ras.write((Character.toString(letter)).getBytes());
        }
        ras.close();
    }
}
