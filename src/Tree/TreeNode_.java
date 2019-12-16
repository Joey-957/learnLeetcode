package Tree;

public class TreeNode_ {
    int val;
    TreeNode_ left;
    TreeNode_ right;
    TreeNode_(int x) { val = x; }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode_ getLeft() {
        return left;
    }

    public void setLeft(TreeNode_ left) {
        this.left = left;
    }

    public TreeNode_ getRight() {
        return right;
    }

    public void setRight(TreeNode_ right) {
        this.right = right;
    }
}
