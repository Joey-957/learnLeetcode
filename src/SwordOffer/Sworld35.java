package src.SwordOffer;

import java.util.HashMap;

/**
 *  深拷贝链表
 */
public class Sworld35 {
    public  Node copyRandomList(Node head){
        HashMap<Node,Node> map = new HashMap<>();
        Node cur = head;
        while (cur!=null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        //复制结点指向
        cur = head;
        while (cur != null){// 通过使用map 将被复制的节点 和 复制后的节点 一一对应起来
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val){
        this.val = val;
        this.next = null;
        this.random = null;
    }
}