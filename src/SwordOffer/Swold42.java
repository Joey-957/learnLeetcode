package src.SwordOffer;

import java.util.Scanner;

/**
 * 连续子数组的最大和
 *
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 */
public class Swold42 {
    /**
     * 方法一，暴力法 时间复杂度是 o（n^2）
     *  拿到每轮最大的值
     */
    public static void main(String[] args) {
        int t = maxSubArray_baoli(new int[]{1,2,3,4,5,-1,-1,-1});
        System.out.println(t);
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int num = sc.nextInt();
        System.out.println(str +" " +num);
    }
    public static int maxSubArray_baoli(int[] nums){
        int length = nums.length;
        int reMax = Integer.MIN_VALUE;
        for (int i = 0;i<length; i++){
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for (int j = i;j<length; j++){
                sum += nums[j];
                max = Math.max(sum,max);
                /* max = (max > max + nums[j])? max: max+ nums[j]; */
            }

            reMax = Math.max(reMax,max);
        }
        return reMax;
    }



}
 class Main{

    static class Node1{
        int val;
        Node1 next;
        public Node1(int val){
            this.val = val;
        }
    }


    public static void main(String[] argus){
        Scanner sc = new Scanner(System.in);

        int length  = sc.nextInt();
        int l = length;
        int k = sc.nextInt();

        Node1 root = new Node1(-1);
        Node1 temp = root;
        while(length > 0){
            length --;
            temp.next = new Node1(sc.nextInt());
            temp = temp.next;
        }
        // root -> 1,2, 3,4,5
        Node1 temp1 = root.next;
        int index = l - k -1 ;
        while(index > 0){
            index --;
            System.out.print(temp1.val + " ");
            temp1 = temp1.next;
        }
        System.out.println(temp1.val + " ");
        temp1 = temp1.next.next;
        while (temp1 != null){
            System.out.print(temp1.val + " ");
            temp1 = temp1.next;
        }






//        Node1 next = root;
//        Node1 cur = root;
//        Node1 root1 = new Node1(-1);
//        root1.next = root;
//
//        Node1 pre = root1;
//        while(k > 0){
//            k--;
//            next = next.next;
//        }
//
//        while(next != null){
//            next = next.next;
//            cur = cur.next;
//            pre = pre.next;
//        }
//        pre.next = cur.next;
//
//        Node1 p = root.next;
//        while(p != null){
//            System.out.print(p.val + " ");
//            p = p.next;
//        }

    }


}
//class Node1{
//    int val;
//    Node1 next;
//    public Node1(int val){
//        this.val = val;
//    }
//}