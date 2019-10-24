package IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 模拟限制使用次数的软件
 * */
public class IO3 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("config.txt");
        int a;
        String temp = "";
        while ((a = fileReader.read()) != -1) {
            temp = temp + (char) a;
        }
        int count = Integer.parseInt(temp) - 1;
        if (count == -1) {
            System.out.println("次数已用完！");
        } else {
            System.out.println("剩余次数：" + count);
            FileWriter fileWriter = new FileWriter("config.txt");
            fileWriter.write(count + "");
            fileWriter.close();
        }
        fileReader.close();
    }
}
