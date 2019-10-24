package datastruct;

public class DoubleNodeTest {
    public static void main(String[] args) {
        DoubleNode node1 = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);
        DoubleNode node4 = new DoubleNode(4);
        node1.add(node2);
        node2.add(node3);
        node3.add(node4);
        node3.show();
    }
}
