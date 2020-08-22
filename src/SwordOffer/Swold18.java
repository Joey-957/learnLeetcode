package src.SwordOffer;

public class Swold18 {
    public ListNode deleteNode(ListNode head,int val){
        if (head == null){
            return null;
        }
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode tempHead = temp;
        while(head!=null){
            if (head.val==val){
                tempHead.next = head.next;
                break;
            }
            tempHead = head;
            head = head.next;
        }
        return temp.next;
    }

    public int[] printNumbersd(int n) {
        //n--;
        int num = 9;
        int sum=0;
        while(n>0){
            sum = sum *10 + num;
            n--;
        }
        return functiond(sum);
    }
    public int[] functiond(int n){
        int[] arr = new int[n];
        for(int i=0, j=1;i<n;i++,j++){
            arr[i] = j;
            System.out.println(j);
        }
        return arr;
    }
    public static void main(String[] args) {

        ListNode pHead = new ListNode(1);
        ListNode pHead1 = new ListNode(2);
        ListNode pHead2 = new ListNode(3);
        ListNode pHead3 = new ListNode(4);
        ListNode pHead4 = new ListNode(5);
        ListNode pHead5 = new ListNode(6);
        ListNode pHead6 = new ListNode(7);
        pHead.next = pHead1;
        pHead1.next = pHead2;
        pHead2.next = pHead3;
        pHead3.next = pHead4;
        pHead4.next = pHead5;
        pHead5.next = pHead6;
        Solution solution = new Solution();
        ListNode root  =  solution.deleteDuplication(pHead);
        new Swold18().printNumbersd(3);
    }


}


class Solution {
    public  ListNode deleteDuplication(ListNode pHead){
        if(pHead==null || pHead.next==null){
            return pHead;
        }
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode pre = head;
        ListNode last = pHead;
        while(last!= null){
            if (last.next!=null && last.val == last.next.val){
                while(last.next!=null && last.val == last.next.val){
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            }else{
                pre = last;
                last = last.next;
            }
        }
        return head.next;

    }
}