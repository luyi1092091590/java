package datastruct;

public class LoopNodeTest {
    public static void main(String[] args) {
        LoopNode node1 = new LoopNode(1);
        LoopNode node2 = new LoopNode(2);
        LoopNode node3 = new LoopNode(3);
        LoopNode node4 = new LoopNode(4);
        node1.add(node2);
        node2.add(node3);
        node3.add(node4);
//        System.out.println(node1.next);
        node3.show();
    }
}
