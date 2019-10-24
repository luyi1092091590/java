package datastruct;

public class HuffManCodeNode implements Comparable<HuffManCodeNode> {
    //data表示字符，weight表示出现次数
    HuffManCodeNode leftNode;
    HuffManCodeNode rightNode;
    Byte data;
    Integer weight;

    public HuffManCodeNode(Byte data, Integer weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "HuffManCodeNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }


//    @Override
//    public String toString() {
//        return "HuffManCodeNode{" +
//                "leftNode=" + leftNode +
//                ", rightNode=" + rightNode +
//                ", data=" + data +
//                ", weight=" + weight +
//                '}';
//    }

    @Override
    public int compareTo(HuffManCodeNode o) {
        return this.weight - o.weight;
    }
}
