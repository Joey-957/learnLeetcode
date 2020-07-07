package src.SwordOffer;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 * <p>
 * <p>
 * 自己的思路： 见到有序查找问题必定不是全遍历，
 * 中序遍历是 左跟右是小中大 的顺序，但是题目是找第 K 大的 并不是 第 K 小的
 * 所以使用改良版中序遍历 ： 右跟左， 当遍历到 k 个节点是 循环跳出即可。
 */
public class Swold54 {

    public int kthLargest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = null;
        while (root != null) {
            stack.push(root);
            root = root.right;
        }
        while (!stack.isEmpty()) {
            temp = stack.pop();
        }
        return 0;
    }

    /**
     * 递归法
     * 包装类中 除了String 其他包装类无法完成引用传递，仍然是值传递，会在赋值过程中自动拆箱
     */
    public int recursion(TreeNode root, int k) {
        List<Integer> list = new LinkedList<>();
        recursions(root, k, list);
        return list.remove(k-1);  // list 也是有数组下标的 第k 个数字 下标是 k-1
    }

    public void recursions(TreeNode root, int k, List<Integer> list) {
        if (root == null || list.size() == k) {
            return;
        }

        recursions(root.right, k, list);

        list.add(root.val);

        recursions(root.left, k, list);

    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.remove(0));
    }

    public static void f(Integer i) {
        i = 9;
    }
}
