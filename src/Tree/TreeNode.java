package Tree;

/**
 * 树的节点定义
 */
public class TreeNode {
    private int data;
    private TreeNode leftTreeNode;
    private TreeNode rightTreeNode;

    public TreeNode(){}

    public TreeNode(int key){
        this.data = key;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftTreeNode() {
        return leftTreeNode;
    }

    public void setLeftTreeNode(TreeNode leftTreeNode) {
        this.leftTreeNode = leftTreeNode;
    }

    public TreeNode getRightTreeNode() {
        return rightTreeNode;
    }

    public void setRightTreeNode(TreeNode rightTreeNode) {
        this.rightTreeNode = rightTreeNode;
    }
}
