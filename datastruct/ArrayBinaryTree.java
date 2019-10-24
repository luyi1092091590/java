package datastruct;

/**
 * 顺序存储的完全二叉树，左儿子2*n+1，右儿子2*n+2
 */

public class ArrayBinaryTree {
    int[] data;

    public ArrayBinaryTree(int[] data) {
        this.data = data;
    }

    public void fronShow() {
        frontShow(0);
    }

    public void frontShow(int index) {
        if (data.length == 0 || data == null) {
            return;
        }
        System.out.println(data[index]);
        if (index * 2 + 1 < data.length) {
            frontShow(index * 2 + 1);
        }
        if (index * 2 + 2 < data.length) {
            frontShow(index * 2 + 2);
        }
    }
}
