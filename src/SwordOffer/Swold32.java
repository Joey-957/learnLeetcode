package src.SwordOffer;

import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.concurrent.DelayQueue;

/**
 * 考察各种二叉树的层次遍历
 * 1.层次遍历，节点值入一个list
 */
public class Swold32 {
    /**
     *
     * 从上到下打印二叉树，返回数组：第一想法：利用队列水平遍历存放到list，然后使用list.size（）循环赋值到数组array，然后返回。
     */
    public int[] levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();    //使用ArrayList 效率会更高
        if (root==null){
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left!=null){
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
        }
        int[] array = new int[list.size()];
        for (int i=0;i<array.length;i++){
            array[i] = list.get(i);
        }
        return array;
    }


    /**
     * 层次遍历结果[
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if(root==null){
            return list;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //list.add(new LinkedList(root.val));
        while(!queue.isEmpty()){
            List<Integer> listIn = new LinkedList<>();
            for(int i=0;i<queue.size();i++){
                TreeNode temp = queue.poll();
                listIn.add(temp.val);
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }
            list.add(listIn);
        }
        return list;
    }

    /**
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
     *
     *  总结：第一次自己做错，答案建议使用双端队列，奇数层尾插法add，偶数层头插法addFirst（）；
     */

    //error:  错误的思路
//    public List<List<Integer>> levelSearch(TreeNode root){
//        Deque<TreeNode> deque = new LinkedList<>();
//        List<List<Integer>> res = new ArrayList<>();
//        if(root != null) {
//            deque.add(root);
//        }
//        while(!deque.isEmpty()) {
//            // 打印奇数层
//            List<Integer> tmp = new ArrayList<>();
//            for(int i = deque.size(); i > 0; i--) {
//                // 从左向右打印
//                TreeNode node = deque.removeFirst();
//                tmp.add(node.val);
//                // 先左后右加入下层节点
//                if(node.left != null) deque.addLast(node.left);
//                if(node.right != null) deque.addLast(node.right);
//            }
//            res.add(tmp);
//            if(deque.isEmpty()) break; // 若为空则提前跳出
//            // 打印偶数层
//            tmp = new ArrayList<>();
//            for(int i = deque.size(); i > 0; i--) {
//                // 从右向左打印
//                TreeNode node = deque.removeLast();
//                tmp.add(node.val);
//                // 先右后左加入下层节点
//                if(node.right != null) deque.addFirst(node.right);
//                if(node.left != null) deque.addFirst(node.left);
//            }
//            res.add(tmp);
//        }
//        return res;
//
//
//    }


    //自己尝试，使用两个双端队列，奇数行和偶数行分开存储，轮流往list里面注入元素
    public List<List<Integer>> levelSeacher(TreeNode root){
        if (root==null){
            return new LinkedList<>();
        }
        List<List<Integer>> lists = new LinkedList<>();

        Deque<TreeNode> listEven = new LinkedList<>();   // 奇数
        Deque<TreeNode> listOdd = new LinkedList<>();
        listEven.add(root);
        while(!listEven.isEmpty()||!listOdd.isEmpty()){
            List<Integer> listIn = new LinkedList<>();
            while (!listEven.isEmpty()) {
                TreeNode temp = listEven.poll();
                listIn.add(temp.val);
                if (temp.left!=null){
                    listOdd.addFirst(temp.left);
                }
                if (temp.right!=null){
                    listOdd.addFirst(temp.right);
                }
            }
            if (!listIn.isEmpty()){
            lists.add(listIn);}
            List<Integer> listIn2 = new LinkedList<>();
            while(!listOdd.isEmpty()){
                TreeNode temp = listOdd.poll();
                listIn2.add(temp.val);
                if (temp.right!=null){
                    listEven.addFirst(temp.right);
                }
                if (temp.left!=null){
                    listEven.addFirst(temp.left);
                }
            }
            if (!listIn2.isEmpty()){
            lists.add(listIn2);}
        }
        return lists;
    }
}
