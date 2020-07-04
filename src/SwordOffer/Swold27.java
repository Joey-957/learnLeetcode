package src.SwordOffer;

import sun.reflect.generics.tree.Tree;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class Swold27 {
    /**
     *
     * 递归法
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = null;
        temp = root.left;
        root.left = root.right;
        root.right = temp;

        root.left = mirrorTree(root.left);
        root.right = mirrorTree(root.right);

        return root;

    }
}
