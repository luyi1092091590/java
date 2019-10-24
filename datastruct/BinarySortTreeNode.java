package datastruct;

/**
 * 二叉排序树节点
 */

public class BinarySortTreeNode {
    int value;
    BinarySortTreeNode leftNode;
    BinarySortTreeNode rightNode;

    public BinarySortTreeNode(int value) {
        this.value = value;
    }

    //给二叉搜索树添加节点
    public void add(BinarySortTreeNode node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.leftNode == null) {
                this.leftNode = node;
            } else {
                this.leftNode.add(node);
            }
        } else {
            if (this.rightNode == null) {
                this.rightNode = node;
            } else {
                this.rightNode.add(node);
            }
        }
    }

    //中序遍历二叉排序树
    public void midShow() {
        if (this.leftNode != null) {
            this.leftNode.midShow();
        }
        System.out.println(this.value);
        if (this.rightNode != null) {
            this.rightNode.midShow();
        }
    }

    public BinarySortTreeNode search(int value) {
        if (this.value == value) {
            return this;
        } else {
            if (value < this.value) {
                if (this.leftNode == null) {
                    return null;
                }
                return this.leftNode.search(value);
            } else {
                if (this.rightNode == null) {
                    return null;
                }
                return this.rightNode.search(value);
            }
        }
    }
}
