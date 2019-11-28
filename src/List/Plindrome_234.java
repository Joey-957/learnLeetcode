package List;

/**
 * 请判断一个链表是否为回文链表。
 */
public class Plindrome_234 {
    //头插法建立链表
    private ListNode headInsertion(ListNode head, int val) {
        ListNode listNode = new ListNode(val);
        listNode.next = head.next;
        head.next = listNode;
        return head;
    }

    //尾插法建立链表
    private ListNode hailInsertion(ListNode head, int val) {
        ListNode listNode = new ListNode(val);

        head.next = listNode;
        head = listNode;
        return head;
    }

    public void printlnList() {
        Plindrome_234 plindrome_234 = new Plindrome_234();
        ListNode head = new ListNode(-1);
        ListNode flag = head;
        for (int i = 0; i < 9; i++) {
            flag = plindrome_234.hailInsertion(flag, i);
        }
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
    //---------------------------------------------------------------
    public boolean isPalindrome(ListNode head) {
        return true;
    }

}
