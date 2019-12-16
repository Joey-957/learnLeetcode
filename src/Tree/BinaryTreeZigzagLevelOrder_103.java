package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回锯齿形层次遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class BinaryTreeZigzagLevelOrder_103 {

    private List<List<Integer>> lists = new LinkedList<>();
    //方法一、递归
    public List<List<Integer>> zigzagLevelOrder(TreeNode_ root){
        if (root==null){
            return lists;
        }else{
            helper(root,0);
        }
        return lists;
    }
    private void helper(TreeNode_ root,int level){
        if (root==null){
            return ;
        }
        List<Integer> list = new LinkedList<>();
        if(lists.size()==level){
            list.add(root.val);
            lists.add(list);
        }else{
            lists.get(level).add(root.val);
        }
        level++;
        if (level%2==1){
            helper(root.left,level);
        }
        else{
            helper(root.right,level);
        }

    }

    //方法二：层次遍历
    public List<List<Integer>> levelOrderSearch(TreeNode_ root){
        List<List<Integer>> lists = new LinkedList<>();
        Queue<TreeNode_> queue = new LinkedList<>();
        TreeNode_ current = null;
        int flag = 1;
        if (root==null){
            return lists;
        }else {
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            int length = queue.size();
            List<Integer> list = new LinkedList<>();
            for(int i = 0;i<length;i++){
                current = queue.poll();
                list.add(current.val);
                if (flag%2==1){            //思路错了。。。。。。

                    flag = 2;
                }else{
                    flag =1;
                }

            }
        }
        return lists;
    }
}
