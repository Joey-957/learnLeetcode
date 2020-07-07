//package src.List;
//
//import src.Tree.TreeNode_;
//
//import java.util.HashMap;
//
///**
// * 有序链表转化成平衡的二叉排序树，
// * 相关题目：有序数组转化成平衡的二叉排序树
// * 思路：遍历二叉树建立哈希表，key是坐标位置，value是链表的值(可行，但用时太多)
// * 官方题解：通过快慢指针得到链表的每个结点的坐标，而不是哈希表
// */
//public class SortedListToBST_109 {
//
//    private HashMap<Integer, Integer> hashMap = new HashMap<>();
//    private Integer max = 0;
//
//    private void listToMap(List.ListNode head) {
//        int i = 0;
//        while (head != null) {
//            hashMap.put(i, head.val);
//            i++;
//            head = head.next;
//        }
//        max = i - 1;
//    }
//
//    public TreeNode_ sortedListToBST(List.ListNode head) {
//        listToMap(head);
//        return helper(0, max);
//    }
//
//    private TreeNode_ helper(int min, int max) {
//        if (min == max) {
//            return new TreeNode_(hashMap.get(min));
//        } else if (min > max) {
//            return null;
//        }
//        int mid = min + ((max - min) >> 1);
//        TreeNode_ root = new TreeNode_(hashMap.get(mid));
//        root.left = helper(min, mid - 1);
//        root.right = helper(mid + 1, max);
//        return root;
//    }
//
//    /**
//     * 方法二：链表使用快慢指针，定位链表中间数据的位置
//     */
//
//    public TreeNode_ sortedListToBST2(List.ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        List.ListNode mid = findMid(head);
//        TreeNode_ node = new TreeNode_(mid.val);
//        if (mid == head) {
//            return node;
//        }
//        node.left = sortedListToBST2(head);
//        node.right = sortedListToBST2(mid.next);
//        return node;
//    }
//
//    private ListNode findMid(ListNode head) {
//        ListNode preNode = null;
//        ListNode slowNode = head;
//        ListNode fastNode = head;
//        while (fastNode != null && fastNode.next != null) {
//            preNode = slowNode;
//            slowNode = slowNode.next;
//            fastNode = fastNode.next.next;
//        }
//        if (preNode != null) {
//            preNode.next = null;
//        }
//        return slowNode;
//    }
//}
