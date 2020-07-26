package src.面试指南左程云;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 序列化二叉树
 *
 * 方法分为两种 ：先序序列化 和层序序列化
 */
public class CD163 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
            left = null;
            right = null;
        }

    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int amount = sc.nextInt();
//        int node1 = sc.nextInt();
//        TreeNode root = null;// 根节点
//        if (amount ==1){
//            root = new TreeNode(node1);
//        }
//        root = getTree(sc);
//        preOrder(root);
//        levelOrder(root);

        String str1 = "12!3!#!#!#!";
        String[] array = str1.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i =0;i<array.length;i++){
            queue.offer(array[i]);
        }
        TreeNode root2 = recurPre(queue);

    }
    //根据先序遍历构建二叉树
    public static TreeNode recurPre(Queue<String> queue){
        String str = queue.poll();
        if (str.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left = recurPre(queue);
        root.right = recurPre(queue);
        return  root;
    }

    public static TreeNode getTree(Scanner sc){
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        TreeNode root = new TreeNode(num1);
        if (num2 != 0 ){
            root.left = getTree(sc);
        }
        if (num3 != 0){
            root.right = getTree(sc);
        }
        return root;
    }

    public static void preOrder(TreeNode root){
         if (root ==null){
             return;
         }
         StringBuffer preString = null;
         preString = recurPre(root);
        System.out.println(preString);
    }
    public static StringBuffer recurPre(TreeNode root){
        if (root == null){
            return new StringBuffer("#!");
        }
//        StringBuffer sb = recurPre(root.left);
//        sb.append(root.val).append("!");
//        sb.append(recurPre(root.right));
//        return
        StringBuffer sb = new StringBuffer(root.val + "!");
        return sb.append(recurPre(root.left)).append(recurPre(root.right));
    }

    public static void levelOrder(TreeNode root){
           if (root == null){
               System.out.println("#!");
               return;
           }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur =null;
        while(!queue.isEmpty()){
            cur = queue.poll();
            if (cur == null){
                System.out.print("#" + "!");
            }else{
                System.out.print(cur.val + "!");
                    queue.offer(cur.left);
                    queue.offer(cur.right);
            }
        }
    }

}

