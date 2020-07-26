package src.面试指南左程云;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Cd106 {

    public static void main(String[] argus){
        Scanner sc = new Scanner(System.in);

        int length  = sc.nextInt();
        int l = length;
        int k = sc.nextInt();


        Node root = new Node(-1);
        Node temp = root;
        while(length > 0){
            length --;
            temp.next = new Node(sc.nextInt());
            temp = temp.next;
        }
        // root -> 1,2, 3,4,5
        Node temp1 = root.next;
        int index = l - k -1 ;
        while(index > 0){
            index --;
            System.out.print(temp1.val + " ");
            temp1 = temp1.next;
        }
        System.out.print(temp1.val + " ");
        temp1 = temp1.next.next;
        while (temp1 != null){
            System.out.print(temp1.val + " ");
            temp1 = temp1.next;
        }
        System.out.println();
    }



    static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }
}
class deleteNode{
    static class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(-1);
        Node t1 = new Node(2);
        Node t2 = new Node(3);
        root.next = t1;
        t1.next = t2;
        Node fast = root;
        Node slow = root;
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow.next = slow.next.next;
        slow.val = slow.next.val;
        slow.next = slow.next.next;
        Node test = root;
        Scanner scanner = new Scanner(System.in);

    }
}

class  test2{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int maxNum = -2147483647 ;
        Integer maxNums = Integer.MAX_VALUE;


        Deque<Integer> queue1 = new LinkedList<>();
        Deque<Integer> queue2 = new LinkedList<>();

        String[] nums = in.nextLine().trim().split(",");

        for(int i = 0;i < nums.length;i++){
            int temp = Integer.parseInt(nums[i]);
            if(temp >= maxNum){
                queue1.offer(temp);
                maxNum =  temp;
            }else{
                queue2.offer(temp);
            }
        }
        int lastNum = -2147483647;
        int q1 = 0;
        int q2 = 0;
        while(!queue1.isEmpty()&& !queue2.isEmpty() ){
            q1 = queue1.peek();
            q2 = queue2.peekLast();
            if(q1 < q2){
                int temp = queue1.poll();
                if(temp == lastNum){
                    continue;
                }else{
                    lastNum = temp;
                    System.out.print(temp+",");
                }

            }
            if(q1 > q2){

                int temp = queue2.pollLast();
                if(temp == lastNum){
                    continue;
                }else{
                    lastNum = temp;
                    System.out.print(temp+",");
                }

            }
            if(q1 ==q2){
                int temp = queue1.poll();
                queue2.poll();
                if(temp == lastNum){
                    continue;
                }else{
                    lastNum = temp;
                    System.out.print(temp+",");
                }
            }

        }
        List<Integer> list = new LinkedList<>();
        while(!queue1.isEmpty()){
            int t = queue1.poll();
            if(t == lastNum){
                continue;
            }else{
                lastNum = t;
                list.add(t);
            }
        }
        while(list.size()>1){
            System.out.print(list.remove(0)+",");
        }
        System.out.print(list.remove(0));


    }
}