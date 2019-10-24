package datastruct;


public class NodeTest {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.append(node2);
        node1.append(node3);
        node1.append(node4);
//        System.out.println(node1.next.next);
//        System.out.println(node3.isEndNode());
        node1.show();
//        node3.removeNext();
//        node1.show();
        node3.inertAfter(new Node(5));
        node1.show();
    }
}
