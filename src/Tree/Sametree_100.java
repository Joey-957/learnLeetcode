package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 分析：采用递归的方法判断两棵树是否相同，
 * 问题分解：根节点是否相同+左子树是否相同+右子树是否相同，当根节点为空时或两棵树的节点不一样是返回；
 * 边界条件：1.两节点都为空return true；
 *         2.两节点任意一个存在：注意：p==null||q==null return false ，用此种方法最简便
 *         3.两节点都存在，如果结点的值不相同 return false;
 *          若以上条件都符合，return function（1左节点，2左节点）&&
 *                                function（1右节点，2右节点）
 */

class Sametree_100 {
    //方法一、递归方法
    boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.getData() != q.getData()) {
            return false;
        }
        return isSameTree(p.getLeftTreeNode(), q.getLeftTreeNode()) &&
                isSameTree(p.getRightTreeNode(), q.getRightTreeNode());
    }
    //方法二、迭代
    boolean IsSameTree(TreeNode p,TreeNode q){
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        TreeNode current1 = null;
        TreeNode current2 = null;
        if (p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        queue1.offer(p);
        queue2.offer(q);
        while(!queue1.isEmpty()&&!queue2.isEmpty()){
            current1 = queue1.poll();
            current2 = queue2.poll();
            if (current1.getData()!=current2.getData()){
                return false;
            }else {
                if (current1.getLeftTreeNode()!=null&&current2.getLeftTreeNode()!=null){
                    queue1.offer(current1.getLeftTreeNode());
                    queue2.offer(current2.getLeftTreeNode());
                }else if (current1.getLeftTreeNode()==null&&current2.getLeftTreeNode()==null){
                    //continue;
                }else{
                    return false;
                }
                if (current1.getRightTreeNode()!=null&&current2.getRightTreeNode()!=null){
                    queue1.offer(current1.getRightTreeNode());
                    queue2.offer(current2.getRightTreeNode());
                }else if (current1.getRightTreeNode()==null&&current2.getRightTreeNode()==null){
                    //continue;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

}

