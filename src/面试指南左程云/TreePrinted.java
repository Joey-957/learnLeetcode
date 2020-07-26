package src.面试指南左程云;

import java.sql.SQLOutput;

/**
 * 如何较为直观的打印二叉树
 *
 * 最小的Integer.MIN_VALUE : -21 亿，int最大是 11位 String 所以前后加两个字符再加上前后各两个空格 = 17
 *
 *
 * Binary Tree :
 *                         R3R
 *                                          L6L
 *         H1H
 *                                          R5R
 *                         L2L
 *                                          L4L
 *
 *
 * 头结点 HnumberH
 * 左节点：LnumL
 * 右节点：RnumR
 */
public class TreePrinted {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        TreePrinted p = new TreePrinted();
        p.printTree(t1);

    }


    public void printTree(TreeNode root){
        System.out.println("Binary Tree :");
        printInOrder(root,0,"H",17);
        System.out.println();
    }

    private void printInOrder(TreeNode node ,int height,String to,int len){
           if (node == null){
               return;
           }
           printInOrder(node.right ,height +1,"R",len);
           String var = to + node.val + to;
           int varLength = var.length();
           int leftLength = (len - varLength) / 2;
           int rightLength = len - varLength - leftLength;
           String leftBase = getSpase(leftLength);
           String rightSpace = getSpase(rightLength);

           System.out.println(getSpase(height * len) + leftBase + var + rightSpace );
           printInOrder(node.left ,height +1,"L",len);

    }
    private String getSpase(int num){
        StringBuffer sb = new StringBuffer(" ");
        for (int i = 1;i < num ; i++){
            sb.append(" ");
        }
        return sb.toString();
    }
}
