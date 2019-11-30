package List;

/**
 * 请判断一个链表是否为回文链表。
 * error:理解成了[1,2,3,4,1,2,3],其实应该是[1,2,3,4,3,2,1]
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

    /**
     * 版本一：理解出错了
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head==null){
            return false;
        }
        //遍历链表，得到链表结点个数
        int amount = 0;
        ListNode flag = head;
        while (flag != null) {
            amount++;
            flag = flag.next;
        }
        if  (amount==1){
            return true;
        }
        if (amount==2){
            if(head.val==head.next.val){
                return true;
            }else{
                return false;
            }
        }
        int temp = amount / 2 + 1;
        flag = head;
        for (int k = 0; k < temp; k++) {
            flag = flag.next;
        }
        while (flag != null) {
            if (flag.val == head.val) {
                flag = flag.next;
                head = head.next;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 版本二：通过使用快慢指针，不用知道节点的个数节能得到中点指针
     * @param head
     * @return
     */
    public boolean isPalindrome_2(ListNode head) {
        if (head==null||head.next==null){
            return true;
        }

        return true;
    }

    public static void main(String[] argus){
        Plindrome_234 plindrome_234 = new Plindrome_234();
        ListNode head = new ListNode(1);
        plindrome_234.headInsertion(head,2);
        plindrome_234.headInsertion(head,2);
        Boolean t = plindrome_234.isPalindrome(head);
        System.out.println(t);
    }

}
