package src.Heap;

import java.util.PriorityQueue;


/**
 *  堆可以被作优先队列使用
 */
class PriorityQueueMy {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();  // 不用比较器，默认升序排序
        PriorityQueue<Integer> queue1 = new PriorityQueue<>((x,y)->{return y-x;}); // 使用了比较器，降序排序
        for (int i = 5;i > 0;i--){
            queue.offer(i);
            queue1.offer(i);
        }
        while(!queue.isEmpty()){
            System.out.print(queue.poll());

        }
        System.out.println();
        while(!queue1.isEmpty()){
            System.out.print(queue1.poll());
        }

    }
}
