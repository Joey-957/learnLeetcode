package SwordOffer;

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
}
