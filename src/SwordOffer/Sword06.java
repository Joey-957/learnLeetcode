package src.SwordOffer;

import java.util.LinkedList;

public class Sword06 {
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        while(head!=null){
            linkedList.addFirst(head.val);
            head = head.next;
        }

        int length = linkedList.size();
        int[] re = new int[length];
        int i=0;
        for (Object num:linkedList) {
            re[i++] = (int) num;

        }
        return re;
    }
}
