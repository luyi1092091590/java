package datastruct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HuffManTest {
    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 6, 1, 4};
        ArrayList<HuffManNode> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new HuffManNode(arr[i]));
        }
        //输出哈夫曼树的递归结构
        System.out.println(huffManTree(list));
    }

    public static ArrayList huffManTree(ArrayList<HuffManNode> list) {
        while (list.size() > 1) {
            Collections.sort(list, new Comparator<HuffManNode>() {
                @Override
                public int compare(HuffManNode o1, HuffManNode o2) {
                    return o1.value - o2.value;
                }
            });
            HuffManNode node1 = list.get(0);
            HuffManNode node2 = list.get(1);
            HuffManNode tempNode = new HuffManNode(node1.value+node2.value);
            tempNode.leftNode = node1;
            tempNode.rightNode = node2;
            list.add(tempNode);
            list.remove(node1);
            list.remove(node2);
        }
        return list;
    }
}
