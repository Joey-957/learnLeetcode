package src.面试指南左程云.ArrayAndmerix;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 找到无序数组中的最小的 K 个数字。
 *
 * 两个方法 ：优先队列方法 和 快速选择算法
 */
public class LeastK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[amount];
        int[] arrK = new int[k];
        for (int i = 0 ; i < amount ; i ++){
            arr[i] = sc.nextInt();
        }
        if (k == amount){
            printArray(arr);

        }else{
            leastKQuickSort(arrK,arr,k);
            printArray(arrK);
        }

    }
    // 该方法是 ：快速选择算法
    public static void leastKQuickSort(int[] arrK , int[] arr,int k){
        int length = arr.length;
        int leftIndex = 0;
        int rightIndex = length -1;
        recursion(arr,leftIndex,rightIndex,k);
        for (int i =0;i<arrK.length;i++){
            arrK[i] = arr[i];
        }
    }

    public static void recursion(int [] arr,int leftIndex,int rightIndex ,int k ){
        if (leftIndex >= rightIndex){
            return;
        }
        int pivoitIndex = getPivot(arr,leftIndex,rightIndex);
        if (k == pivoitIndex){
            return;
        }else{
            if (k < pivoitIndex){
                recursion(arr,leftIndex,pivoitIndex-1,k);
            }else{
                recursion(arr,pivoitIndex+1,rightIndex,k);
            }
        }
    }
    public static int getPivot(int[] arr,int leftIndex,int rightindex){
        int pivot = arr[leftIndex];
        int pivotIndex = leftIndex;
        while(leftIndex < rightindex){
            while (leftIndex < rightindex && arr[rightindex] > pivot){
                rightindex--;
            }
            while (leftIndex <rightindex && arr[leftIndex] <= pivot){
                leftIndex++;
            }
            if (leftIndex < rightindex){
                int temp = arr[leftIndex];
                arr[leftIndex] = arr[rightindex];
                arr[rightindex] = temp;
            }
        }
        int temp = arr[leftIndex];
        arr[leftIndex] = pivot;
        arr[pivotIndex] = temp;
        return leftIndex;
    }
///////////////////////////////////////////////////////////////////////////////
    public static void printArray(int[] arr){
        int length = arr.length;
        for (int i =0;i<length;i++){
            System.out.print(arr[i] + " ");
        }
    }
    private static  void leastK(int[] arrK , int[] arr , int k){
        Queue<Integer> queue = new PriorityQueue<>((x,y)->{return y - x;});
        for (int i =0;i<arr.length ;i++){
            if (queue.size() < k){
                queue.offer(arr[i]);
            }else{
                if (arr[i] < queue.peek()){
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
        }
        for (int j =0;j<k;j++){
            arrK[j] = queue.poll();
        }
    }




}
