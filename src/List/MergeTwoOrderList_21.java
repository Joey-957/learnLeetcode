package List;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoOrderList_21 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
            this.next = null;
        }
    }
    //测试用例
    public ListNode returnList1(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        return node1;
    }
    public ListNode returnList2(){
        ListNode node_a = new ListNode(1);
        ListNode node_b = new ListNode(2);
        ListNode node_c = new ListNode(5);
        ListNode node_d = new ListNode(6);
        ListNode node_e = new ListNode(9);
        node_a.next = node_b;
        node_b.next = node_c;
        node_c.next = node_d;
        node_d.next = node_e;
        return node_a;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode l3 = new ListNode(0);
        ListNode flag = l3;

        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                flag.next = l1;
                flag = l1;
                l1 = l1.next;
            }else{
                flag.next = l2;
                flag = l2;
                l2 = l2.next;
            }
        }
        if (l1==null){
            flag.next = l2;
        }
        if (l2==null){
            flag.next = l1;
        }
        l3 = l3.next;
        return l3;
    }

    public static void main(String[] argus){
        MergeTwoOrderList_21 one = new MergeTwoOrderList_21();

        ListNode listNode1 = one.returnList1();
        ListNode listNode2 = one.returnList2();
        //one.mergeTwoLists(listNode1,listNode2);
        ListNode listNode110 = one.mergeTwoLists(listNode1,listNode2);
        ListNode flag = listNode110;
        while(flag!=null){
            System.out.println(flag.val);
            flag = flag.next;
        }

    }

}
