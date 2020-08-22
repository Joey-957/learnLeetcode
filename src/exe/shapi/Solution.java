package src.exe.shapi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution =  new Solution();
       solution.invalidTransaction(new String[]{"alice,20,800,sz","alice,50,100,sg"});

//        String str1 = "alice,20,800,sz";
//        String[] arr = str1.split(",");


    }

    public int firstMissingPositive (int[] nums) {
        int length = nums.length;
        int outPutNumber = 1;
        int cur = 0;//bianli
        for (int i = 0;i<length;i++){
            cur = nums[i];
            if (cur == outPutNumber){
                outPutNumber++;
            }
        }
        System.out.println(outPutNumber);
        return outPutNumber;
    }

    // 2
    public boolean isPalindrome (ListNode pHead) {
        // write code here
        boolean flag = false;
        if (pHead ==null){
            return false;
        }
        if (pHead.next == null){
            return true;
        }
        ListNode slow = pHead.next;
        ListNode fast = pHead;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //slow 循环结束后指向链表中间偏后的节点。
        while (slow!=null){
            if (slow.val != pHead.val){
                System.out.println(flag);
                return flag;
            }
            slow = slow.next;
            pHead = pHead.next;
        }
        flag = true;
        System.out.println(flag);
        return flag;
    }


    // 第三题
    public String[] invalidTransaction (String[] vTransaction) {
        // write code here
        int k = vTransaction.length; // 几组数据
        String[][] demo = new String[k][4];
        int returnFre = 0;
        String[] reString = null;
        for (int i=0,m=0;i<k;i++,m++){
            demo[m] = vTransaction[i].split(",");
        }
        List<String> list = new LinkedList<>();
        int skip = -1;
        int kkk = 0;
        for (int j = 0;j<k;j++){
            if (j == skip){
                continue;
            }
            int temp = Integer.parseInt(demo[j][2]);
            if ( temp> 1000){
               list.add(vTransaction[j]);
               kkk = kkk+1;
               continue;
            }
            for (int m = j;m < k;m++){
                if (demo[j][0].equals(demo[m][0]) && !demo[j][3].equals(demo[m][3])){
                    int t1 = Integer.parseInt(demo[j][1]);
                    int t2 = Integer.parseInt(demo[m][1]);
                    if (Math.abs((t1-t2)) <= 60){
                        list.add(vTransaction[j]);
                        list.add(vTransaction[m]);
                        kkk = kkk+1;
                        skip = m;
                    }
                }
            }
        }
        reString = new String[kkk];
        String[] test = list.toArray(reString);
        System.out.println(Arrays.toString(test));
        return test;
    }
}
 class ListNode {
    int val;
   ListNode next = null;
 }
