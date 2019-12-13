package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */

public class SymmetricTree_101 {
    /**
     * @return true or false
     * 递归方法：if比较的两节点值同时为空时返回true，if不等或者一节点为空，另一节点不为空返回false，
     *          都不满足则继续传递return  isSymmeticTree（t1.left,t2.right）&&isSymmetricTree（t1.right,t2.left）；
     *
     * 难点：不同以往的是：初始问题第一次分解递归，和随后的分解递归参数不同
     */
    public boolean isSymmetricTree(TreeNode root){
        return isMirror(root,root);
    }
    //判断两树节点是否为对称结构
    private boolean isMirror(TreeNode rootLeft,TreeNode rootRight){
        if(rootLeft==null&&rootRight==null){
            return true;
        }
        if(rootLeft==null||rootRight==null){
            return false;
        }
        return rootLeft.getData()==rootRight.getData()
                &&isMirror(rootLeft.getLeftTreeNode(),rootRight.getRightTreeNode())
                &&isMirror(rootRight.getLeftTreeNode(),rootLeft.getRightTreeNode());
    }
    //方法二、采用迭代的方法
    public boolean iteration(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return true;
        }
        queue.offer(root);
        queue.offer(root);
        TreeNode current1 = null;
        TreeNode current2 = null;
        while(!queue.isEmpty()){
            current1 = queue.poll();
            current2 = queue.poll();
            if (current1==null&&current2==null){
                //return true;  不能直接返回true 否则左树节点为空就会直接判定为true
                continue;
            }
            if (current1==null||current2==null){
                return false;
            }
            if(current1.getData()!=current2.getData()) {
                return false;
            }
            queue.offer(current1.getLeftTreeNode());
            queue.offer(current2.getRightTreeNode());
            queue.offer(current1.getRightTreeNode());
            queue.offer(current2.getLeftTreeNode());
        }
        return true;
    }

}
