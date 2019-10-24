package datastruct;

import java.util.*;

/**
 * 利用哈弗曼编码对数据进行压缩编码
 */
public class HuffManCode {
    public static void main(String[] args) {
        String msg = "can you can a can as a can canner can a can.";
        byte[] bytes = msg.getBytes();
        System.out.println(Arrays.toString(bytes));
        System.out.println(bytes.length);
        ArrayList<HuffManCodeNode> list = getNodes(bytes);
        System.out.println(creadHuffManTree(list).rightNode);
        HuffManCodeNode tree = creadHuffManTree(list);
        System.out.println("===============");
//        getCodes(tree);
//        System.out.println(hashMap);
//        System.out.println(sb);
        fun(tree, "");
//        look(tree);
        System.out.println(hashMap);
    }

    //统计每个字符出现的次数，并转为节点
    public static ArrayList<HuffManCodeNode> getNodes(byte[] bytes) {
        HashMap<Byte, Integer> hashMap = new HashMap<>();
        for (byte elem : bytes) {
            if (hashMap.containsKey(elem)) {
                hashMap.put(elem, hashMap.get(elem) + 1);
            } else {
                hashMap.put(elem, 1);
            }
        }
        Set<Map.Entry<Byte, Integer>> set = hashMap.entrySet();
        ArrayList<HuffManCodeNode> list = new ArrayList<>();
        for (Map.Entry<Byte, Integer> elem : set) {
            list.add(new HuffManCodeNode(elem.getKey(), elem.getValue()));
        }
        return list;
    }

    //创建哈夫曼树
    public static HuffManCodeNode creadHuffManTree(ArrayList<HuffManCodeNode> list) {
        while (list.size() > 1) {
            Collections.sort(list);
            HuffManCodeNode node1 = list.get(0);
            HuffManCodeNode node2 = list.get(1);
            HuffManCodeNode parents =
                    new HuffManCodeNode(null, node1.weight + node2.weight);
            parents.leftNode = node1;
            parents.rightNode = node2;
            list.add(parents);
            list.remove(node1);
            list.remove(node2);
        }
        return list.get(0);
    }

    //创建哈夫曼编码表
//    public static void getCodes(HuffManCodeNode tree) {
//        if (tree == null) {
//            return;
//        }
//        getCodes(tree.leftNode, "0", sb);
//        getCodes(tree.rightNode, "1", sb);
//    }

    static StringBuilder sb = new StringBuilder();
    static HashMap<Byte, String> hashMap = new HashMap<>();

    //    public static void getCodes(HuffManCodeNode node, String code, StringBuilder s) {
//        StringBuilder sb2 = new StringBuilder(s);
//        sb2.append(code);
//        if (node.data == null) {
//            getCodes(node.leftNode, "0", sb2);
//            getCodes(node.rightNode, "1", sb2);
//        } else {
//            hashMap.put(node.data, sb2.toString());
//        }
//    }

    public static void fun(HuffManCodeNode node, String code) {
        if (node == null) {
            return;
        }
        sb.append(code);
        fun(node.leftNode, "0");

        fun(node.rightNode, "1");
        if (node.data != null) {
            System.out.println(sb.toString());
            hashMap.put(node.data, sb.toString());
        }
        //每个节点的左右孩子都遍历完才减去字符串最后一个数
        if (sb.length() != 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
