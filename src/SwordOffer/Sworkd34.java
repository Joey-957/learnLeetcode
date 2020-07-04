package src.SwordOffer;

import java.util.*;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 */
public class Sworkd34 {

    /**
     *
     * 心得体会：改了很多最终问题在 判断节点返回时会重复同一路径两次
     *     1
     *  * / \
     *   2   2
     *
     *
     */

    public List<List<Integer>> lists = new LinkedList<>();

    //public Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if (root == null ) {
            return lists;
        }
//        if (root.val == sum && root.left == null && root.right == null) {
//            Integer val = root.val;
//            List<Integer> list = new LinkedList<>();
//            list.add(val);
//            lists.add(list);
//                                                                                      增加了判断叶子节点后，不需要这些判断
//
//            return lists;
//        }
//        if (root.val == sum && (root.left == null || root.right == null)) {
//
//            return lists;
//        }
        LinkedList<Integer> list = new LinkedList<>();
        recursion(root, sum, list);

        return lists;
    }

    public void recursion(TreeNode root, int sum, LinkedList<Integer> list) {
        if (root.left == null&&root.right==null) {         //判断是不是叶子节点！！
            if (root.val==sum){
                list.add(root.val);
                lists.add(new LinkedList<>(list));
                return;
            }
        }
        list.add(root.val);                       // 1. 选择该节点
        sum -= root.val;
        if (root.left!=null){
            recursion(root.left, sum, list);      // 2.  递归后，作回退操作
        }
        list.removeLast();
        if (root.right!=null){
            recursion(root.right, sum, list);
        }
        list.removeLast();                        // 3.  也是如上步，递归后作回退操作（，每次完成递归之后都有回退操作！！）
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        Sworkd34 s = new Sworkd34();
        s.pathSum(n1,3);
        System.out.println(s.lists);


        List<List<Integer>> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        List<Integer> list1 = new LinkedList<>(set);
        list.add(list1);
        System.out.println(list);

    }
}
/**
        正确答案 ：本问题是典型的二叉树方案搜索问题，使用回溯法解决，其包含 先序遍历 + 路径记录 两部分
 */
class Swold34{
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }
    void recur(TreeNode root, int tar) {
        if(root == null) return;
        path.add(root.val);
        tar -= root.val;
        if(tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList(path));
        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast();               //  这里只需要回退一次接可以了，因为 叶子节点的上两次递归都进去后立刻推出，
                                                //  所以list 回退到 该叶子结点的父节点 下一步 遍历他的兄弟节点。
    }
}