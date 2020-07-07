package src.Tree;

/**
 * 反转一棵二叉树，采用递归法
 * 拆解问题：反转一棵二叉树=反转子树的左右两棵子树，边界条件：if（root==null）return；
 * 先处理交换当前root的左右两个子节点，然后继续递归当前节点的左子树，继续递归当前节点的右子树，最终返回root；
 */
public class InvertBinaryTree_226 {

    //自己写的
    public TreeNode recursion(TreeNode root) {
        TreeNode temp = null;
        if (root == null) {
            return null;
        }
        //没必要判断左右两节点是否为空
//        if (root.getLeftTreeNode()==null&&root.getRightTreeNode()!=null){
//            root.setLeftTreeNode(root.getRightTreeNode());
//            root.setRightTreeNode(null);
//        }else if (root.getLeftTreeNode()!=null&&root.getRightTreeNode()==null){
//            root.setRightTreeNode(root.getLeftTreeNode());
//            root.setLeftTreeNode(null);
//        }else if (root.getLeftTreeNode()!=null&&root.getRightTreeNode()!=null){
//            temp  = root.getLeftTreeNode();
//            root.setLeftTreeNode(root.getRightTreeNode());
//            root.setRightTreeNode(temp);
//        }
        temp = root.getLeftTreeNode();
        root.setLeftTreeNode(root.getRightTreeNode());
        root.setRightTreeNode(temp);
        recursion(root.getLeftTreeNode());
        recursion(root.getRightTreeNode());
        return root;
    }

    //leecode官方：
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.getLeftTreeNode());
        TreeNode right = invertTree(root.getRightTreeNode());
        root.setLeftTreeNode(right);
        root.setRightTreeNode(left);
        return root;
    }

}
