package src.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。
 * (即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 分析：层次遍历+栈，倒置列表输出
 */
public class BinaryTreeLevelSearchII_107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<Integer> listDemo = new LinkedList<Integer>();
        List<List<Integer>> lists = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List> stack = new Stack<>();
        TreeNode current = null;
        if (root == null) {
            //lists.add(null);
            return lists;
        } else {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> list = new LinkedList<Integer>();
            for (int i = 0; i < length; i++) {
                current = queue.poll();
                list.add(current.getData());
                if (current.getLeftTreeNode() != null) {
                    queue.offer(current.getLeftTreeNode());
                }
                if (current.getRightTreeNode() != null) {
                    queue.offer(current.getRightTreeNode());
                }
            }
            stack.push(list);
        }
        while (!stack.empty()) {
            listDemo = stack.pop();
            lists.add(listDemo);
        }
        return lists;
    }

    //方法二，不使用栈，使用链表将每次层次遍历得到的list使用头插法，放进链表头，实现逆转
    public List<List<Integer>> levelOrderBottom_2(TreeNode root) {

        LinkedList lists = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode current = null;
        if (root == null) {
            //lists.add(null);
            return lists;
        } else {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> list = new LinkedList<Integer>();//每次取出一层的所有数据

            for (int i = 0; i < length; i++) {
                current = queue.poll();
                list.add(current.getData());
                if (current.getLeftTreeNode() != null) {
                    queue.offer(current.getLeftTreeNode());
                }
                if (current.getRightTreeNode() != null) {
                    queue.offer(current.getRightTreeNode());
                }
            }
            lists.addFirst(list);  //采用头插法
        }

        return lists;
    }
}
