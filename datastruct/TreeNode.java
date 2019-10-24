package datastruct;

public class TreeNode {
    private int value;
    private TreeNode leftNode;
    private TreeNode rightNode;

    public TreeNode(int value) {
        this.value = value;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }

    //前序遍历
    public void frontShow() {
        System.out.println(value);
        if (leftNode != null) {
            leftNode.frontShow();
        }
        if (rightNode != null) {
            rightNode.frontShow();
        }
    }

    //中序遍历
    public void midShow() {
        if (leftNode != null) {
            leftNode.midShow();
        }
        System.out.println(value);
        if (rightNode != null) {
            rightNode.midShow();
        }
    }

    //后序遍历
    public void afterShow() {
        if (leftNode != null) {
            leftNode.afterShow();
        }
        if (rightNode != null) {
            rightNode.afterShow();
        }
        System.out.println(value);
    }

    //前序查找
    public TreeNode fronSearch(int num) {
        TreeNode temp = null;
        if (num == value) {
            return this;
        } else {
            if (leftNode != null) {
                temp = leftNode.fronSearch(num);
            }
            if (temp != null) {
                return temp;
            }
            if (rightNode != null) {
                temp = rightNode.fronSearch(num);
            }
        }
        return temp;
    }
    //删除子树
    public void delete(int num) {
        TreeNode parsent = this;
        if (parsent.leftNode != null && parsent.leftNode.value == num) {
            parsent.leftNode = null;
            return;
        }
        if (parsent.rightNode != null && parsent.rightNode.value == num) {
            parsent.rightNode = null;
            return;
        }
        parsent = leftNode;
        if (parsent != null) {
            parsent.delete(num);
        }
        parsent = rightNode;
        if (parsent != null) {
            parsent.delete(num);
        }
    }
}
