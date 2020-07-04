package List_new_listnode;



public class Reverse24 {
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

