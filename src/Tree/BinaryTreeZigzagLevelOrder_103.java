package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 返回锯齿形层次遍历如下：
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class BinaryTreeZigzagLevelOrder_103 {

    private List<List<Integer>> lists = new LinkedList<>();

    /**
     * 方法一、递归.
     * 树的深度level对应list[level]，根据的奇偶决定每层的数据是头插法还是尾插法。
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode_ root) {
        if (root == null) {
            return lists;
        } else {
            helper(root, 0);
        }
        return lists;
    }

    private void helper(TreeNode_ root, int level) {
        if (root == null) {
            return;
        }
        LinkedList<Integer> list = new LinkedList<>();
        if (lists.size() == level) {
            if (level % 2 == 0) {
                list.add(root.val);
            } else {
                list.addFirst(root.val);
            }
            lists.add(list);
        } else {
            if (level % 2 == 0) {
                lists.get(level).add(root.val);
            } else {
                LinkedList list1 = (LinkedList) lists.get(level);
                list1.addFirst(root.val);
            }
        }
        level++;
        helper(root.left, level);
        helper(root.right, level);
    }

    //方法二：层次遍历
    public List<List<Integer>> levelOrderSearch(TreeNode_ root) {
        List<List<Integer>> lists = new LinkedList<>();
        Queue<TreeNode_> queue = new LinkedList<>();
        TreeNode_ current = null;
        int flag = 1;
        if (root == null) {
            return lists;
        } else {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {   //原来思路错了。。。。。。应该管出不管进
            int length = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < length; i++) {
                current = queue.poll();
                if (flag % 2 == 0) {
                    //list.add(current.val);
                    list.addFirst(current.val);
                } else {
                    list.add(current.val);
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            lists.add(list);
            flag += 1;
        }
        return lists;
    }
}
