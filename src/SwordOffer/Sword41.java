package src.SwordOffer;

import sun.awt.image.ImageWatched;
import sun.nio.ch.ThreadPool;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 数据流中的中位数
 *  自己想的暴力法超出时间限制
 *  尝试二；自己维护一个递增链表，遍历循环插入
 */
public class Sword41 {

    Queue<Integer> A, B;
    public Sword41() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }
    public void addNum(int num) {
        if(A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }
    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }













    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();

        Queue<Integer> a = new PriorityQueue<>();
        Queue<Integer> b = new PriorityQueue<>((x,y)->(y-x));
        a.offer(7);
        a.offer(6);
        a.offer(5);

        b.offer(1);
        b.offer(3);
        b.offer(5);
        b.offer(7);
        while (!a.isEmpty()){
            System.out.println(a.peek());
            a.poll();
        }
        while (!b.isEmpty()){
            System.out.println(b.peek());
            b.poll();
        }

    }
}

class MedianFinder2 {
    /** initialize your data structure here. */
    List<Integer> list = null;
    int num = 0;
    //Integer[] arrays = null;
    public MedianFinder2() {
        this.list = new LinkedList<>();
        this.num = 0;
    }

    public void addNum(int num) {
        list.add(num);
        this.num++;
    }

    public double findMedian() {
        Integer[] arrays = new Integer[this.num];
        this.list.toArray(arrays);
        Arrays.sort(arrays);
        if ((this.num & 1) ==1){
            return arrays[num/2];
        }else{
            return (arrays[num/2]+arrays[num/2-1])/2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder2 m = new MedianFinder2();
        m.addNum(6);
        m.findMedian();
        m.addNum(2);
        m.findMedian();
        m.addNum(10);
        System.out.println(m.findMedian());
    }
}

/**
 * 自己维护增链表。和链表节点数 num
 */
class MedianFinder {

    Node root = null;
    int number = 0;
    Node pre = null; //遍历节点
    Node next = null; // 遍历后节点
    public MedianFinder() {
//        this.root = new Node(Integer.MAX_VALUE);  //添加头节点
//        this.num = 1;
    }

    public void addNum(int num) {


        if (root == null){
            root = new Node(num);
            //cur = root;
            this.number++;
            return;
        }if (number ==1){
            if (num>root.val){
                root.next = new Node(num);
            }else{
                Node t = new Node(num);
                t.next = root;
                root = t;
            }
            this.number++;
        }
        else{
            pre = root;
            next = root.next;
            while (next!= null &&pre.val<num && next.val < num){
                pre = next;
                next = next.next;
            }
            if (pre.val>num){
                root = new Node(num);
                root.next = pre;
                pre = root;
                this.number++;
                return;
            }
            if (next!=null){
                pre.next = new Node(num);
                pre.next.next = next;
                pre = root;
                next = pre.next;
            }
            if (next==null){
                pre.next = new Node(num);
            }
            this.number++;

        }
//        this.num++;
    }

    public double findMedian() {
        pre = root;
        if ((this.number & 1) ==1){
            int num = this.number /2;
            while(num>0){
                pre = pre.next;
                num--;
            }
            int n = pre.val;
            pre = root;
            return n;

        }else{
            int num = this.number/2 -1;
            while(num>0){
                pre = pre.next;
                num--;
            }
            double re  = (pre.val + pre.next.val)/2.0;
            pre = root;
            return re;
        }

    }
    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(6);
        m.findMedian();
        m.addNum(10);
        m.addNum(2);
        m.addNum(6);
        m.addNum(5);
        m.addNum(5);


//        m.findMedian();
//        m.addNum(10);
//        m.addNum(10);
//        m.addNum(10);
//        m.addNum(10);
//        m.addNum(10);
//        m.addNum(10);
//        m.addNum(10);
//        m.addNum(10);

        System.out.println(m.findMedian());
    }
}