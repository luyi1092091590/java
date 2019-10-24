package datastruct;

public class BinaryTree {
    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void fronShow() {
        if (root != null) {
            root.frontShow();
        }
    }

    public void delete(int num) {
        if (root.getValue() == num) {
            root = null;
        } else {
            root.delete(num);
        }
    }
}
