package src.Heap;

import java.util.PriorityQueue;

/**
 * leetcode 最小的K个数，和最大的k 个数
 *
 * 建立一个优先队列，小顶堆， 存入队列，由于大顶堆弹出的序列是升序排序的，所以一次弹出前k个元素即可。
 *
 *  关于优先队列：默认优先数组使用的是小顶堆，入队列出队的过程中，队列一直在维护一个小顶堆，
 *              弹出的时候，优先弹出栈顶，所以弹出的序列是递增序列。
 *
 *              如果优先队列使用比较器，入队列的过程中，队列一直在维护一个维护大顶堆，所以弹出
 *              优先弹出栈顶，所以弹出的序列是递减序列
 *
 */
public class ThelastestK {

    public static void main(String[] args) {
        ThelastestK t = new ThelastestK();
        int[] array = new int[]{7,1,0,6,9,5,3,4,6,8,3,5,9,6,0,2,4};
        int[] small = t.smallestK(array,3);
        int[] big = t.biggestK(array,4);

    }

    public int[] smallestK(int[] arr, int k) {
           if (arr == null || arr.length ==0){
               return new int[k];
           }
           int[] returnArray = new int[k];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
           for (int i : arr){
               priorityQueue.offer(i);
           }
           for (int i=0;i< k;i++){
               returnArray[i] = priorityQueue.poll();
           }
           return returnArray;
    }

    // 返回 k 个 最大的数
    public int[] biggestK(int[] arr, int k) {
        if (arr == null || arr.length ==0){
            return new int[k];
        }
        int[] returnArray = new int[k];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x,y)->{return y - x;});
        for (int i : arr){
            priorityQueue.offer(i);
        }
        for (int i=0;i< k;i++){
            returnArray[i] = priorityQueue.poll();
        }
        return returnArray;
    }
}
