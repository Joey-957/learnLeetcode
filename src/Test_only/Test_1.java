package Test_only;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test_1 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1};

        int max = nums[0];
        for (int num:nums){
            max = max>=num? max:num;
        }


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