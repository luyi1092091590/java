package datastruct;

public class ThreadTreeNode {
    int value;
    ThreadTreeNode leftNode;
    ThreadTreeNode rightNode;
    //指针类型，1为前驱或后继，0位子节点
    int leftType;
    int rightTyte;
    public ThreadTreeNode(int value){
        this.value = value;
    }
    public void setLeftNode(ThreadTreeNode leftNode){
        this.leftNode = leftNode;
    }
    public void setRightNode(ThreadTreeNode rightNode){
        this.rightNode = rightNode;
    }
}
