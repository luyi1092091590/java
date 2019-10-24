package datastruct;

public class BinarySortTree {
    BinarySortTreeNode root;

    public void add(BinarySortTreeNode node){
        if (root==null){
            root = node;
        }else {
            root.add(node);
        }
    }

    public void midShow(){
        root.midShow();
    }
    public BinarySortTreeNode search(int value){
        return root.search(value);
    }
}
