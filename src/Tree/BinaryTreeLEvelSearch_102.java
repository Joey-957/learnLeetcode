package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class BinaryTreeLEvelSearch_102 {

    /**
     * 层次遍历，使用queue.size(),区分每层入队的数据
     * @param root 树的根节点
     * @return list
     */
    public List<List<Integer>> levelOrder(TreeNode_ root) {
        List<List<Integer>> lists = new LinkedList<>();
        TreeNode_ current = null;
        Queue<TreeNode_> queue = new LinkedList<>();
        if (root==null){
            return lists;
        }else{
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int queueSize = queue.size();    // ！！注意保存queue的size到一个变量，下一行不能写i<queue.Size(),因为该值是队列的属性，会变化
            for(int i=0;i<queueSize;i++){
                current = queue.poll();
                list.add(current.val);
                if (current.left!=null){
                    queue.offer(current.left);
                }
                if (current.right!=null){
                    queue.offer(current.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }

    /**
     * 方法二、递归的方式
     *
     */
    //成员变量
    private List<List<Integer>> lists = new LinkedList<>();

    public List<List<Integer>> Recursion(TreeNode_ root){
        if (root==null){
            return lists;
        }
        else{
            return infixSearch(root,0);
        }

    }

    public List<List<Integer>> infixSearch(TreeNode_ root,int level){
        if (root!=null){
            List<Integer> list = new LinkedList<>();
            if(lists.size()==level){
                list.add(root.val);
                lists.add(level,list);
            }else {
                lists.get(level).add(root.val);//.get()先找到对应的list，这步犯过错
            }
        }else{
            return lists;
        }
        level = level+1;
        infixSearch(root.left,level);
        infixSearch(root.right,level);
        return lists;
    }
}
