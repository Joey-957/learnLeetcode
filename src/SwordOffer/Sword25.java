package SwordOffer;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 新建一个链表
 *
 */
public class Sword25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }
        if (l2 == l1){
            return l1;
        }
        ListNode l3 =new ListNode(-1);
        ListNode flag = l3;

        while(l1!=null&&l2!=null) {
            if (l2.val <= l1.val) {
                l3.next = l2;
                l2 = l2.next;
                l3 = l3.next;
            }
            else {
                l3.next = l1;
                l1 = l1.next;
                l3 = l3.next;
            }
        }
        if (l1==null){
            l3.next = l2;
        }else{
            l3.next =l1;
        }

        return flag.next;
    }



}
