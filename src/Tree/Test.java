package Tree;

import java.util.*;

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
        a.setLeft(b);
        a.setRight(c);

        TreeNode_ d = new TreeNode_(4);
        TreeNode_ e = new TreeNode_(5);
        TreeNode_ f = new TreeNode_(6);
        c.setLeft(e);
        c.setRight(f);
        b.setLeft(d);

        //BinaryTreeLevelSearchII_107 binaryTreeLevelSearchII_107 = new BinaryTreeLevelSearchII_107();
        //List list = binaryTreeLevelSearchII_107.levelOrderBottom_2(a);

        BinaryTreeZigzagLevelOrder_103 binaryTreeZigzagLevelOrder_103 = new BinaryTreeZigzagLevelOrder_103();
        List<List<Integer>> list = binaryTreeZigzagLevelOrder_103.zigzagLevelOrder(a);
        System.out.println(list);






    }
}
