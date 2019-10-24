package datastruct;

/**
 * 循环单链表
 */

public class LoopNode {
    int data;
    LoopNode next = this;

    public LoopNode(int data) {
        this.data = data;
    }

    public void add(LoopNode node) {
        LoopNode nextnext = this.next;
        this.next = node;
        node.next = nextnext;
    }
//输出循环链表中所有元素
    public void show() {
        LoopNode current = this;
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
        return "单前节点值：" + data;
    }
}
