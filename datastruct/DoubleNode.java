package datastruct;

/**
 * 循环双向链表
 */
public class DoubleNode {
    DoubleNode front = this;
    DoubleNode next = this;
    int data;

    public DoubleNode(int data) {
        this.data = data;
    }

    public void add(DoubleNode node) {
        DoubleNode nextnext = this.next;
        this.next = node;
        node.front = this;
        node.next = nextnext;
        nextnext.front = node;
    }

    //显示所有元素
    public void show() {
        DoubleNode current = this;
        System.out.println(current);
        current = current.next;
        //到达调用对象是停止循环
        while (current != this) {
            System.out.println(current);
            current = current.next;
        }
    }

    @Override
    public String toString() {
        return "当前节点的值：" + data;
    }
}
