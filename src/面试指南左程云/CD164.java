package src.面试指南左程云;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CD164 {
    public static void main(String[] argus){
        Scanner sc = new Scanner(System.in);
        Queue<TreeNode> queue = new LinkedList<>();
        while(sc.hasNext()){
            int i = sc.nextInt();
            TreeNode root = null;
            if(i>0){
                root = new TreeNode(sc.nextInt());
                queue.offer(root);
            }else{
                pre(root);
                System.out.println();
                in(root);
                System.out.println();
                next(root);
                System.out.println();
                continue;
            }
            while(i>0){
                i--;
                TreeNode cur = queue.poll();
                int temp = sc.nextInt();
                int leftNum = sc.nextInt();
                if(leftNum == 0){
                    cur.left = null;
                }else{
                    cur.left = new TreeNode(leftNum);
                    queue.offer(cur.left);
                }
                int rightNum = sc.nextInt();
                if(rightNum ==0 ){
                    cur.right = null;
                }else{
                    cur.right = new TreeNode(rightNum);
                    queue.offer(cur.right);
                }

            }
            pre(root);
            System.out.println();
            in(root);
            System.out.println();
            next(root);
            System.out.println();

        }
    }

    public static void pre(TreeNode root){
        if(root ==null){
            return;
        }
        System.out.print(root.val + " ");
        pre(root.left);
        pre(root.right);


    }
    public static void in(TreeNode root){
        if(root ==null){
            return;
        }
        in(root.left);
        System.out.print(root.val + " ");
        in(root.right);

    }

    public static void next(TreeNode root){
        if(root ==null){
            return;
        }

        next(root.left);
        next(root.right);
        System.out.print(root.val + " ");
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}
