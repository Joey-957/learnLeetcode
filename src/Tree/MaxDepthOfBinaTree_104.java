package Tree;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */

/**
 * 采用递归的方式，求解二叉树深度的问题可以分解成：
 * 1（根节点）+max（左子树的深度+右子树的深度），结束条件是root为null时返回0；
 * 递归公式如下：
 * if（root==null）{
 *      return 0；
 * }else{
 *     return 1+max(root.leftNode,root.rightNode);
 * }
 *
 */
class MaxDepthOfBinaTree_104 {

    int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }else {
            int leftDepth = maxDepth(root.getLeftTreeNode());
            int rightDepth = maxDepth(root.getRightTreeNode());
            return Math.max(leftDepth,rightDepth)+1;
        }
    }
}
