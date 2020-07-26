package src.面试指南左程云;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 左程云： 前中后 序遍历 的自己控制输入输入版本
 * 目的主要是 学习 ：构建 输入输出  // 已验证 是正确的
 */
public class CD161 {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        Collections.reverse(list);
        while(list.size() >0){
            System.out.println(list.remove(0));
        }
        int t = 912421;
        String out = String.valueOf(t);
        int fre = out.length();
        for (int k = 0; k < fre; k++) {

            System.out.print(out.charAt(k) + " ");
        }

        //采用输入流接收输入
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //将第一次换行符前的所以输入以空格分开并保存成字符串的形式
        String[] strings1 = bf.readLine().split(" ");

        //作为结果的输出流
        StringBuilder sb = new StringBuilder();
        //创建树
        TreeNode treeNode = createTreeCore(bf);

//        //前序遍历
//        preOrder(treeNode,sb);
//        //因为在前序遍历时会多添加一个空格，因此这里最后一个空格不能读取
//        System.out.println(sb.substring(0,sb.length()-1));
//        //清空
//        sb.delete(0,sb.length());
//        //中序遍历
//        innerOrder(treeNode,sb);
//        System.out.println(sb.substring(0,sb.length()-1));
//        sb.delete(0,sb.length());
//        reviewOrder(treeNode,sb);
//        System.out.println(sb.substring(0,sb.length()-1));
    }

    //创建一个树的结点
    private static TreeNode createTreeCore(BufferedReader in) throws Exception {
        //把一行转为整数
        int[] nodes = getIntArray(in.readLine());
        //数组中第一个数是根节点
        TreeNode node = new TreeNode(nodes[0]);
        //通过递归确定了层数
        if (nodes[1] != 0) {
            //左孩子
            node.left = createTreeCore(in);
        }
        if (nodes[2] != 0) {
            //右孩子
            node.right = createTreeCore(in);
        }
        return node;
    }

    //把接收到的字符串转换成整数
    private static int[] getIntArray(String str) {
        String[] temp = str.split(" ");
        int[] result = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            result[i] = Integer.parseInt(temp[i]);
        }
        return result;
    }
}
//自己尝试 根据牛客网节点输入构建二叉树，然后打印输出三序遍历；

class  TestTree{
    private static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        int num1 = sc.nextInt();
        Node root = null;
        if (amount ==1){
            root = new Node(num1);
            sout(root);
            return;
        }
        root = recursion(sc);
        sout(root);
    }

    public static Node recursion(Scanner sc ){
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        Node root = new Node(num1);
        if (num2 != 0){
            root.left = recursion(sc);
        }
        if (num3 != 0){
            root.right = recursion(sc);
        }
        return root;
    }

    // 遍历二叉树函数
    public static void sout(Node root){
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        bhOrder(root);
    }
    public static void preOrder(Node root){
        if (root ==null){
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    public static void bhOrder(Node root){
        if (root ==null){
            return;
        }
        bhOrder(root.left);
        bhOrder(root.right);
        System.out.print(root.val + " ");
    }

}

/**
 *  两个链表 相加
 */
class Main2 {
    public static void main(String[] argus) {
        Scanner sc = new Scanner(System.in);
        int length1 = sc.nextInt();
        int length2 = sc.nextInt();
        Node root1 = new Node(-1);
        Node cur1 = root1;
        while (length1 > 0) {
            length1--;
            cur1.next = new Node(sc.nextInt());
            cur1 = cur1.next;
        }

        Node root2 = new Node(-1);
        Node cur2 = root2;
        while (length2 > 0) {
            length2--;
            cur2.next = new Node(sc.nextInt());
            cur2 = cur2.next;
        }
        root1 = root1.next;
        root2 = root2.next;
        root1 = reverse(root1);  // 链表头
        root2 = reverse(root2);  // 链表头

        int ca = 0;
        int sum = 0;
        // 建立新头结点,使用头插法 就不用反转数组了
        Node newNode = null;
        while (root1 != null && root2 != null) {
            if (ca != 0) {
                sum = root1.val + root2.val + ca;

            } else {
                sum = root1.val + root2.val;
            }
            ca = sum / 10;
            Node root = new Node(sum % 10);
            root.next = newNode;
            newNode = root;
            root1 = root1.next;
            root2 = root2.next;
        }
        Node root = null;
        while (root1 != null) {

            root = new Node((root1.val + ca) % 10);
            ca = (root1.val + ca) / 10;

            root.next = newNode;
            newNode = root;
            root1 = root1.next;

        }


        while (root2 != null) {
            root = new Node((root2.val + ca) % 10);
            ca = (root2.val + ca) / 10;

            root.next = newNode;
            newNode = root;
            root2 = root2.next;
        }

        if (ca ==1){
            Node rootT = new Node(ca);
            rootT.next = newNode;
            newNode = rootT;
        }

        while (newNode != null) {
            System.out.print(newNode.val + " ");
            newNode = newNode.next;

        }


    }

    public static Node reverse(Node root) {
        Node pre = null;
        Node next = null;
        while (root != null) {
            next = root.next;
            root.next = pre;
            pre = root;
            root = next;
        }
        return pre;
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}



class TTT{


    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        int num1 = sc.nextInt();
        TreeNode root = null;
        if(amount == 1){
            root = new TreeNode(num1);
            sout1(root);
            sout2(root);
            return;
        }
        root = recurToTree(sc);
        sout1(root);
        System.out.println();
        sout2(root);
    }
    public static TreeNode recurToTree(Scanner sc){
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        TreeNode root = new TreeNode(num1);
        if(num2 != 0){
            root.left = recurToTree(sc);
        }
        if(num3 != 0){
            root.right = recurToTree(sc);
        }
        return root;

    }

    public static void sout1(TreeNode root){
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        Deque<Integer> queue3 = new LinkedList<>();
        if(root != null){
            queue1.offer(root);
        }
        TreeNode cur = null;
        while(!queue1.isEmpty()){
            int length =  queue1.size();
            for(int i =0;i < length;i++){
                cur = queue1.poll();
                if(cur.left != null){
                    queue1.offer(cur.left);
                }
                if(cur.right != null){
                    queue1.offer(cur.right);
                }

                if(i == 0 || (cur.left == null && cur.right == null && i !=length-1)){
                    queue2.offer(cur.val);
                }
                if(i == length -1){
                    queue3.offer(cur.val);
                }
            }
        }
        //sout
        while(!queue2.isEmpty()){

            System.out.print(queue2.poll() + " ");
        }
        while(!queue3.isEmpty()){
            System.out.print(queue3.pollLast() + " ");
        }
    }



    public static void sout2(TreeNode root){

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        Deque<Integer> queue3 = new LinkedList<>();
        if(root != null){
            queue1.offer(root);
        }
        TreeNode cur = null;
        while(!queue1.isEmpty()){
            int length =  queue1.size();
            for(int i =0;i < length;i++){
                cur = queue1.poll();
                if(cur.left != null){
                    queue1.offer(cur.left);
                }
                if(cur.right != null){
                    queue1.offer(cur.right);
                }
                //sout
                if((i == 0 && cur.left != null)|| (cur.left == null && cur.right == null)){
                    queue2.offer(cur.val);
                }
                if(i == length -1 && cur.right != null){
                    queue3.offer(cur.val);
                }
            }
        }
        //sout
        while(!queue2.isEmpty()){

            System.out.print(queue2.poll() + " ");
        }

    }


}