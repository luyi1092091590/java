package datastruct;
/**
 * 哈夫曼树节点
 * */

public class HuffManNode {
    int value;
    HuffManNode leftNode;
    HuffManNode rightNode;

    public HuffManNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HuffManNode{" +
                "value=" + value +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }
}
