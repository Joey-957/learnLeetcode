package List;

import java.util.Stack;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class InvertedLIst_206 {

    private ListNode returnList() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        return listNode1;
    }

    /**
     *
     * @param head
     * @return
     *
     * 方法一、使用堆栈，执行起来太慢
     */
//    public ListNode reverseList(ListNode head){
//        if(head==null||head.next==null){
//            return head;
//        }
//        Stack<Integer> stack = new Stack<>();
//        ListNode flag_1 = head;
//        ListNode flag_2 = head;
//        do {
//            stack.push(flag_1.val);
//            flag_1 = flag_1.next;
//        }while(flag_1!=null);
//        do {
//            flag_2.val = stack.pop();
//            flag_2 = flag_2.next;
//        }while (flag_2!=null);
//        return head;
//    }

    /**
     * 方法二、不使用堆栈,
     * @param head
     */
//    public ListNode reverseList(ListNode head){
//        if(head==null||head.next==null){
//            return head;
//        }
//        ListNode prev = null;
//        ListNode current = head;
//        ListNode next = head;
//        while(current!=null){
//            next = current.next;
//            current.next = prev;
//            prev = current;
//            current = next;
//            //current = current.next;
//        }
//        return prev;
//    }

    /**
     * 方法三、递归
     */
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode flag = reverseList(head.next);//拿到临界条件，然后下一步做处理
        head.next.next = head;
        head.next = null;
        return flag;
    }

    public static void main(String[] argus) {
        InvertedLIst_206 invertedLIst = new InvertedLIst_206();
        ListNode listNode = invertedLIst.returnList();
        ListNode listNode1 = invertedLIst.reverseList(listNode);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
}
