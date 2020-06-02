package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class PathSumII_113 {

    private List<List<Integer>> list = new LinkedList<>();

    private LinkedList<Integer> queue = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode_ root, int sum) {
        if (root == null) {
            return list;
        }
        queue.offer(root.val);
        int sumEnd = sum - root.val;
        if (root.left == null && root.right == null) {
            if (sumEnd == 0) {
                list.add((List<Integer>) queue.clone());
                queue.pollLast();
                return list;
            } else {
                queue.pollLast();
                return list;
            }
        }
        pathSum(root.left, sumEnd);
        pathSum(root.right, sumEnd);
        queue.pollLast();
        return list;
    }
}
