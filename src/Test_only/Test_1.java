package src.Test_only;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test_1 {
    public static void main(String[] args) {
        String str1 = "abcdAB";
        char[] chs = str1.toCharArray();
        char[] chars = new char[]{'a','b','c','d','A','B'};
        boolean flag = Character.isLetter(chars[0]);
        char ch = chars[0];
        char A = Character.toLowerCase(ch);
        char a = Character.toUpperCase(ch);

//        int[] nums = new int[]{1,1,1,1};
//
//        int max = nums[0];
//        for (int num:nums){
//            max = max>=num? max:num;
//        }


        }
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode temp = new ListNode(1);
        temp.next = head;
        //head = temp;
        ListNode low,fast;
        low = head;
        fast = head.next;
        if(fast==null){
            return low;
        }

        //temp_lost1 = low;

        while(fast!=null){
            low.next=temp;
            temp=low;
            low = fast;
            fast = fast.next;
        }
        low.next = temp;
        head.next = null;
        return low;

    }
}
 class ListNode {
              int val;
             ListNode next;
              ListNode(int x) { val = x; }

}