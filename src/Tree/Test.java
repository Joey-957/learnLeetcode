package Tree;

import java.util.*;
import List.*;

/**
 * 测试类
 */
public class Test {
    //生成测试树
    private static TreeNode returnRoot(){
        TreeNode A = new TreeNode(4);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(6);
        TreeNode D = new TreeNode(1);
        TreeNode E = new TreeNode(3);
        TreeNode F = new TreeNode(5);
        TreeNode G = new TreeNode(7);

        B.setLeftTreeNode(D);
        B.setRightTreeNode(E);
        C.setLeftTreeNode(F);
        C.setRightTreeNode(G);
        A.setLeftTreeNode(B);
        A.setRightTreeNode(C);
        return A;
    }

    public static void main(String[] argus) {
        TreeNode root = Test.returnRoot();
        FunctionOfTreeImpletion one = new FunctionOfTreeImpletion();
        //one.insertTreeNode(7,root);
        //TreeNode find = one.findTreeNode(7,root);
        //System.out.println(find.getData());
//        one.postOrder(root);
//        System.out.println("==");
//        one.preOrder(root);
//        System.out.println("==");
//        one.infixOrder(root);
//        TreeNode min = one.MinNum(root);
//        System.out.println(min.getData());
//        min = one.MaxNum(root);
//        System.out.println(min.getData());

        TreeNode_ a = new TreeNode_(1);
        TreeNode_ b = new TreeNode_(2);
        TreeNode_ c = new TreeNode_(3);
        a.left = b;
        a.right = c;

        TreeNode_ d = new TreeNode_(4);
        TreeNode_ e = new TreeNode_(3);
        TreeNode_ f = new TreeNode_(6);
        TreeNode_ G = new TreeNode_(0);
        c.left = e;
        c.right = f;
        b.left = G;
        b.right = d;

        //测试，有序链表转化二叉排序树
//        ListNode A = new ListNode(1);
//        ListNode B = new ListNode(3);
//        ListNode C = new ListNode(5);
//        ListNode D = new ListNode(7);
//        ListNode E = new ListNode(9);
//        A.next = B;
//        B.next = C;
//        C.next = D;
//        D.next = E;
//        SortedListToBST_109 qq = new SortedListToBST_109();
//        TreeNode_ Root = qq.sortedListToBST2(A);

//        BTInorderTraversal_94 btInorderTraversal_94 = new BTInorderTraversal_94();
//        List list  = btInorderTraversal_94.postorderTraversal(a);
//        System.out.println(list);
//        List<Integer> list4 = new ArrayList<>();
//        list4.add(1);
//        list4.add(2);
//        Integer q = list4.get(0);
//        list4.size();


    }
}
