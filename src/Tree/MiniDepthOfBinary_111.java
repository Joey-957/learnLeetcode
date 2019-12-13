package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 分析：可以递归或者层次遍历
 * 递归分解问题：root根节点的最小深度 = 1+min（root左子树节点的最小深度，root右子树节点的最小深度）
 */
public class MiniDepthOfBinary_111 {
     //方法一、递归（自己写的、还是思路不清晰）
//     public int miniRecursion(TreeNode root){
//         int miniDepth = 0;
//         if (root!=null&&root.getLeftTreeNode()==null&&root.getRightTreeNode()==null){
//             return 1;
//         }
//         if (root==null){
//             return 0;
//         }
//         if (root.getLeftTreeNode()!=null||root.getRightTreeNode()!=null){
//             miniDepth++;
//         }
//         //除零以外要最小的
//         //return miniDepth+min(miniRecursion(root.getLeftTreeNode()),miniRecursion(root.getRightTreeNode()));
//         if (root.getLeftTreeNode()!=null){
//             return miniDepth+miniRecursion(root.getLeftTreeNode());
//         }
//         if (root.getRightTreeNode()!=null){
//             return miniDepth+miniRecursion(root.getRightTreeNode());
//         }
//         return 0;
//     }

     //方法二、递归（leecode官方）
    public int miniDepth(TreeNode root){
         if(root==null){
             return 0;
         }
         if(root.getLeftTreeNode()==null&&root.getRightTreeNode()==null){
             return 1;
         }
         int miniDepth =Integer.MAX_VALUE;
         if (root.getLeftTreeNode()!=null) {
             miniDepth = java.lang.Math.min(miniDepth(root.getLeftTreeNode()),miniDepth);
         }
         if (root.getRightTreeNode()!=null) {
             miniDepth = java.lang.Math.min(miniDepth(root.getRightTreeNode()),miniDepth);
         }
         return 1+miniDepth;
    }

    //层次遍历,对属于树的同一深度的节点进行归类和统一处理
    public int levelSearch(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        if (root!=null){
            depth = 1;
            queue.offer(root);
        }else {
            return 0;
        }
        TreeNode current = null;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++) {
                current = queue.poll();
                if (current != null) {
                    //depth++;
                    if (current.getLeftTreeNode() == null && current.getRightTreeNode()== null) {
                        return  depth;
                    }
                }
                if (current.getLeftTreeNode() != null) {
                    queue.offer(current.getLeftTreeNode());
                }
                if (current.getRightTreeNode() != null) {
                    queue.offer(current.getRightTreeNode());
                }
            }
            depth++;
        }
        return depth;
    }
}
