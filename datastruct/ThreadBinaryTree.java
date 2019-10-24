package datastruct;

public class ThreadBinaryTree {
    ThreadTreeNode root;
    ThreadTreeNode pre;

    public void setRoot(ThreadTreeNode root) {
        this.root = root;
    }

    //中序线索二叉树，调用后将叶子结点用线索串起来
    public void threadNodes() {
        threadNodes(root);
    }

    public void threadNodes(ThreadTreeNode node) {
        if (node == null) {
            return;
        }
        threadNodes(node.leftNode);
        if (node.leftNode == null) {
            node.leftNode = pre;
            node.leftType = 1;
        }
        if (pre != null && pre.rightNode == null) {
            pre.rightNode = node;
            pre.rightTyte = 1;
        }
        pre = node;
        threadNodes(node.rightNode);
    }

    //遍历线索二叉树
    public void threadIterate() {
        ThreadTreeNode node = root;
        while (node != null) {
            while (node.leftType==0){
                node = node.leftNode;
            }
            System.out.println(node.value);
            while (node.rightTyte==1){
                node = node.rightNode;
                System.out.println(node.value);
            }
            node = node.rightNode;
        }
    }
}
