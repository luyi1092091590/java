package IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * 词频统计
 * */

public class IO2 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("IO作业一.txt");
        int a;
        HashMap<Character, Integer> hashMap = new HashMap();
        while ((a = fileReader.read()) != -1) {
            hashMap.put((char) a, hashMap.containsKey((char) a) ? hashMap.get((char) a) + 1 : 1);
        }
        System.out.println(hashMap);
        FileWriter fileWriter = new FileWriter("count.txt");
        Set<Map.Entry<Character, Integer>> set = hashMap.entrySet();
        System.out.println("合并" + set);
        for (Map.Entry<Character, Integer> elem : set) {
            if (elem.getKey() == '\n') {
                fileWriter.write("\\n=" + elem.getValue()+'\n');
            }else if(elem.getKey()=='\r'){
                fileWriter.write("\\r=" + elem.getValue()+'\n');
            } else {
                fileWriter.write(elem.toString());
                fileWriter.write('\n');
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
