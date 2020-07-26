package src.面试指南左程云;

import java.util.Stack;

/**
 * 单链表，每K 个节点逆序
 */
public class CD119 {


    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        CD119 cd119 = new CD119();
        Node head = cd119.reverseKNode2(n1,3);

    }


    public Node reverseKNode(Node head, int k){
        if (k < 2){
            return head;
        }
        Stack<Node> stack = new Stack<>();
        Node newHead = head;
        Node cur = head;
        Node pre = null;
        Node next = null;
        while(cur != null){
            next = cur.next;
            stack.push(cur);
            if (stack.size() == k){
                pre = resign(stack,pre,next);
                newHead = newHead == head ? cur : newHead;
            }
            cur = next;
        }
        return newHead;
    }

    public Node resign(Stack<Node> stack,Node left,Node right){
        Node cur = stack.pop();
        if (left !=null){
            left.next = cur;
        }
        Node next = null;
        while(!stack.isEmpty()){
            next = stack.pop();
            cur.next = next;
            cur = cur.next;
        }
        cur.next = right;
        return cur;
    }

    //再写一遍
    public Node reverseKNode2(Node head, int k){
        if(k < 2){
            return head;
        }
        Stack<Node> stack = new Stack<>();
        Node pre = null;
        Node cur = head;
        Node next = null;

        Node newHead = head;
        while(cur != null){
            stack.push(cur);
            next = cur.next;
            if (stack.size() == k){
                pre = resign2(stack,pre,next);
                if (newHead == head) {    //仅仅调用一次
                    newHead = cur;
                }
            }
            cur = next;
        }
            return newHead;
    }

    public Node resign2(Stack<Node> stack,Node left,Node right){
        Node current = stack.pop();
        if (left != null) {
            left.next = current;
        }
        while(!stack.isEmpty()){
            current.next = stack.pop();
            current = current.next;
        }
        current.next = right;
        return current;
    }

}
