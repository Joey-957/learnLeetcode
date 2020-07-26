package src.面试指南左程云;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * 使用栈判断 是否链表回文
 */
public class Cd111 {

    public static void main(String [] argus){


        Scanner sc = new Scanner(System.in);
        int fre2 = sc.nextInt();

        //boolean odd = ( fre & 1) == 1 ? true : false;

        Stack<Integer> stack = new Stack<>();
        if((fre2&1)==1){
            int fre3 = fre2/2;
            while(fre3>0){
                fre3 --;
                stack.push(sc.nextInt());
            }
            sc.nextInt();
            while(!stack.isEmpty()){
                if(sc.nextInt() != stack.pop()){
                    System.out.print("false");
                    return;
                }
            }
            System.out.print("true");
        }else{
            int fre3 = fre2 /2;
            while(fre3>0){
                fre3 --;
                stack.push(sc.nextInt());
            }
            //sc.nextInt();
            while(!stack.isEmpty()){
                if(sc.nextInt() != stack.pop()){
                    System.out.print("false");
                    return;
                }
            }
            System.out.print("true");
        }

    }
}
/**
 *  不是用来栈 判断是否回文
 *  通过反转后半部分链表，判断是不是回文链表
 */
class Huiwenlianbiao{
    public static void main(String [] argus){
        Scanner sc = new Scanner(System.in);
        int listNumber = sc.nextInt();  // 链表节点数量
        int pre = listNumber;
        ListNode root = new ListNode(-1);
        ListNode cur = root; //遍历节点
        while(pre > 0){
            pre --;
            cur.next = new ListNode(sc.nextInt());
            cur = cur.next;
        }
        root = root.next;
        if (root == null || root.next == null){ // 单个节点链表 和 双节点链表 肯定的是回文的，直接返回；
            System.out.println("true");
            return;
        }
        ListNode fast = root;
        ListNode slow = root.next;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode cur2 = reverse(slow);  //  记得使用 慢指针节点 ，不要带入root
        while(cur2 != null){
            if (cur2.val != root.val){
                System.out.println("false");
                return ;
            }
            cur2 = cur2.next;
            root = root.next;
        }
        System.out.println("true");
    }

    public static ListNode reverse(ListNode root){
        ListNode pre = null;
        ListNode next = null;
        while(root !=null){
            next= root.next;
            root.next = pre;
            pre = root;
            root = next;
        }
        return pre;
    }
}

/**
 *  使用map 赋值 复杂链表
 */
class sb{
    static class Node {
        int val;
        Node next;
        Node random;
        public Node(int val){
            this.val = val;
        }
    }
    public static Node test(Node head ) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Map<Node,Node> map = new HashMap<>();
        while(cur !=null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}