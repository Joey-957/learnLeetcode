package List;

/**
 * 仅仅知道需要删除链表的节点指针（非尾节点），如何删掉该节点？？
 */
public class DeleteListNode_237 {
    public void deleteListNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
