package src.Tree;

/**
 * 二叉排序树，的增删查方法接口
 */

public interface FunctionOfTree {
    //查找结点
    public TreeNode findTreeNode(int key, TreeNode root);

    //插入节点
    public boolean insertTreeNode(int key, TreeNode root);

    //删除节点
    public boolean delete(int key, TreeNode root);
}
