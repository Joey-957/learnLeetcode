package src.exe.Youzan;

import java.util.LinkedList;
import java.util.List;

public class Main {
    class ListNode {
   int val;
    ListNode next = null;
  }
    public boolean isPalindrome (ListNode head) {
        String str = "";
        while(head!= null){
            str +=head.val;
            head = head.next;
        }
        return isPalindrome(str);
    }
    private boolean isPalindrome(String str){
        int lo= 0,hi = str.length()-1;
        while(lo<hi){
            if (str.charAt(lo) !=str.charAt(hi)){
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}

class maisn3{

    private int max;
    public int maxSumDivFive (int[] nums) {
        // write code here
        max = 0;
        maxSumDivFive(nums,0,0);
        return max;

    }
    private void maxSumDivFive(int[] nums,int idx,int val){
        if(idx == nums.length){
            if(val%5==0){
                max = Math.max(max,val);
            }
        }
        else{
            maxSumDivFive(nums,idx+1,val+nums[idx]);
            maxSumDivFive(nums,idx+1,val);
        }
    }

}
