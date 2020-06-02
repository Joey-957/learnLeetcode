package List;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class RemoveValElemList_203 {

    //使用了快慢指针，没插入头节点，处理了删除的节点在头结点的情况；
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while (head.val == val) {

            if ((head = head.next) == null) {
                return null;
            }
        }
        ListNode low = head, fast = head.next;

        while (fast != null) {
            if (fast.val == val) {
                low.next = fast.next;

            } else {

                low = low.next;
            }
            fast = fast.next;
        }

        return head;
    }
}
