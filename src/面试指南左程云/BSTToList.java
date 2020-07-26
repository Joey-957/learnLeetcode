package src.面试指南左程云;

import com.sun.org.apache.bcel.internal.generic.DLOAD;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * BST 转化为双向链表
 */
public class BSTToList {

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

    static class DoubleList{
        int val;
        DoubleList pre;
        DoubleList next;

        DoubleList(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        int node1 = sc.nextInt();
        TreeNode root = null;// 根节点
        if (amount ==1){
            root = new TreeNode(node1);
        }
        root = getTree(sc);

        Queue<Integer> queue = new LinkedList<>();
        inorder(root,queue);
        DoubleList node  = returnList(queue);



    }
    public static DoubleList returnList(Queue<Integer> queue){
        DoubleList root = new DoubleList(-1);
        DoubleList cur = root;
        while(!queue.isEmpty()){
            DoubleList temp = new DoubleList(queue.poll());
            cur.next = temp;
            temp.pre = cur;
            cur = cur.next;
        }
        DoubleList node = root.next;
        node.pre = null;
        return node;
    }

    private static void inorder(TreeNode root ,Queue<Integer> queue){
        if (root ==null){
            return;
        }
        inorder(root.left,queue);
        queue.offer(root.val);
        inorder(root.right,queue);
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


}
