package datastruct;

public class ThreadBinaryTreeTest {
    public static void main(String[] args) {
        ThreadBinaryTree tree = new ThreadBinaryTree();
        ThreadTreeNode root = new ThreadTreeNode(1);
        tree.setRoot(root);
        ThreadTreeNode leftNode = new ThreadTreeNode(2);
        ThreadTreeNode rightNode = new ThreadTreeNode(3);
        root.setLeftNode(leftNode);
        root.setRightNode(rightNode);
        leftNode.setLeftNode(new ThreadTreeNode(4));
        ThreadTreeNode node5 = new ThreadTreeNode(5);
        leftNode.setRightNode(node5);
        rightNode.setLeftNode(new ThreadTreeNode(6));
        rightNode.setRightNode(new ThreadTreeNode(7));
        tree.threadNodes();
        tree.threadIterate();
        System.out.println("===================");
        System.out.println(node5.rightNode.value);
    }
}
