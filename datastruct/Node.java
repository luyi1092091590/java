package datastruct;


/**
 * 单链表节点
 */
public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node append(Node node) {
        Node currentNode = this;
        while (true) {
            Node nextNode = currentNode.next;
            if (nextNode == null) {
                break;
            }
            currentNode = nextNode;
        }
        currentNode.next = node;
        return this;
    }

    public boolean isEndNode() {
        if (this.next == null) {
            return true;
        } else {
            return false;
        }
    }

    //显示当前对象后面所有节点的值
    public void show() {
        Node currentNode = this;
        while (true) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
            if (currentNode == null) {
                break;
            }
        }
        System.out.println();
    }
    //删除当前节点后面的第一个节点
    public void removeNext(){
        this.next = this.next.next;
    }
    //插入当前节点的后面
    public void inertAfter(Node node){
        Node nextnext = this.next;
        this.next = node;
        node.next = nextnext;
    }

    @Override
    public String toString() {
        return "当前节点的值：" + data;
    }
}
