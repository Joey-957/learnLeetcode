package src.面试指南左程云;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 反转单向链表
 */
public class CD107 {

    public static void main(String [] argus){

        List list = new LinkedList();
        list.add(1);
        list.add(1);
        list.add(1);
        while(list.size()!=0){
            list.get(0);
        }


        Scanner sc = new Scanner(System.in);
        int length1 = sc.nextInt();
        ListNode root = new ListNode(-1);
        ListNode cur = root;
        while(length1 > 0){
            length1--;
            cur.next = new ListNode(sc.nextInt());
            cur = cur.next;
        }
        reverse(root.next);

        int length2 = sc.nextInt();
        DoubleNode doot = new DoubleNode(0);   //构建双向链表
        doot.pre = null;
        DoubleNode temp = doot;
        while(length2 > 0){
            length2--;
            DoubleNode current = new DoubleNode(sc.nextInt());
            temp.next = current;
            current.pre = temp;
            temp = temp.next;

        }
        reverse(doot);

    }
    public static void reverse(ListNode root){
        ListNode head = root;
        ListNode next =null;
        ListNode pre = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            //next = head.next;
            head = next;
        }
        while(pre !=null){
            System.out.print(pre.val + " ");
            pre = pre.next;
        }
        System.out.println();
    }
    public static void reverse(DoubleNode root){
        DoubleNode head = root.next;
        head.pre = null;
        while(head.next !=null){
            head = head.next;
        }
        while(head !=null){
            System.out.print(head.val + " ");
            head= head.pre;
        }
    }
}
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}

class DoubleNode{
    int val;
    DoubleNode pre;
    DoubleNode next;
    public DoubleNode(int val){
        this.val = val;
    }
}

/**
 * 反转部分单向链表
 */
class Test{
    public static void main(String [] argus){

        Scanner sc = new Scanner(System.in);
        ListNode root = new ListNode(-1);
        ListNode bianli = root;
        int fre = sc.nextInt();
        while(fre > 0){
            fre --;
            bianli.next = new ListNode(sc.nextInt());
            bianli = bianli.next;
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        ListNode rootnew = reversePart( root.next,start,end);
        while(rootnew !=null){
            System.out.print(rootnew.val + " ");
            rootnew = rootnew.next;
        }
    }
    // head 并非无效的头节点，是第一个实际节点
    public static ListNode reversePart(ListNode head,int from,int to){
        int len =0;
        ListNode node1 = head;
        ListNode fpre = null;
        ListNode tpos = null;
        while(node1 !=null){
            len ++;
            fpre = len == from - 1 ? node1 : fpre;
            tpos = len == to + 1 ? node1 : tpos;
            node1 = node1.next;
        }
        // 无效数据
        if (from > to || from < 1 || to > len){
            return head;
        }
        node1 = fpre ==null ? head : fpre.next;
        ListNode node2 = node1.next;
        node1.next = tpos;
        ListNode next = null;
        while(node2 != tpos){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (fpre != null){
            fpre.next = node1;
            return  head;
        }
        return node1;
    }
}