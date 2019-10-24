package datastruct;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree binTree = new BinaryTree();
        TreeNode root = new TreeNode(1);
        binTree.setRoot(root);
        TreeNode leftNode = new TreeNode(2);
        root.setLeftNode(leftNode);
        TreeNode rightNode = new TreeNode(3);
        root.setRightNode(rightNode);
        TreeNode treeNode4 = new TreeNode(4);
        leftNode.setLeftNode(treeNode4);
        System.out.println(root);
        leftNode.setRightNode(new TreeNode(5));
        rightNode.setLeftNode(new TreeNode(6));
        rightNode.setRightNode(new TreeNode(7));
        System.out.println("前序===============");
        root.frontShow();
        System.out.println("中序===============");
        root.midShow();
        System.out.println("后序===============");
        root.afterShow();
        System.out.println("======删除========");
//        System.out.println(root.fronSearch(9));
        binTree.delete(1);
        binTree.fronShow();
//        System.out.println(root==binTree.getRoot());
    }
}
