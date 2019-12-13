package Tree;

import java.util.HashMap;
import java.util.Map;

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
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        //a.setLeftTreeNode(b);
        //b.setRightTreeNode(c);

        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(2);
        d.setRightTreeNode(f);
        d.setLeftTreeNode(e);
        MiniDepthOfBinary_111 miniDepthOfBinary_111 = new MiniDepthOfBinary_111();
        int depth = miniDepthOfBinary_111.levelSearch(d);

        System.out.println(depth);
        System.out.println("-----");
        int test_1 = Integer.MIN_VALUE;
        int test_2 = Integer.MAX_VALUE;
        System.out.println(test_1+"  "+test_2);

    }
}
