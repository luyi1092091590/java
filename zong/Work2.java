package zong;

import java.io.RandomAccessFile;

public class Work2 {
    public static void main(String[] args) throws Exception {
        String olderString = "*****  ******";
        String newString = "核心提示：第十二任台湾地区领导人选举今日举行，马萧(马英九、萧万长)竞选总部统计宣称已获得超过700万张选票，自行宣布当选。";
        repalceString(olderString, newString, "a.txt");
    }

    public static void repalceString(String olderString,
                                     String newString, String path) throws Exception {
        RandomAccessFile raf = new RandomAccessFile(path, "rw");
        String line = "";
        String temp = "";
        int len = 0;
        long index = 0;
        int flag = 0;
        while ((line = raf.readLine()) != null) {
            len = line.length() + len;
            if (line.contains(olderString) && flag == 0) {
                flag = 1;
                if (len == raf.length()) {
                    temp = line.replace(olderString, newString);
                    index = raf.getFilePointer() - line.length();
                    raf.seek(index);
                    raf.write(temp.getBytes());
                } else {
                    index = raf.getFilePointer() - line.length() - 2;
                }
            }
            if (flag == 1) {
                temp = temp + new String(line.getBytes("iso-8859-1")) + "\r" + "\n";
            }
        }
        temp = temp.replace(olderString, newString);
        raf.seek(index);
        raf.write(temp.getBytes());
        raf.close();
    }
}
