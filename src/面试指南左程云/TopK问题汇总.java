package src.面试指南左程云;

import javafx.scene.layout.Priority;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class TopK问题汇总 {
    // 剑指offer 40 ，最小的 k个 数
    // 思路是 利用大根堆，先装满 k 个数，然后和比较栈顶元素比较 小于栈顶 则弹出栈顶 该元素入堆，最后就是 k个最小数
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr==null|| arr.length == 0 || k==0){
            return new int[]{};
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((x,y)->{return y-x;});
        int cur =0;
        for (int i =0;i< arr.length;i++){
            cur = arr[i];
            if (queue.size()<k){
                queue.offer(cur);
            }else{
                if (queue.element()>cur){
                    queue.poll();
                    queue.offer(cur);
                }
            }
        }
        int [] array = new int[k];
        for (int i = 0;i<k;i++){
            array[i] = queue.poll();
        }
        return array;
    }

    /**
     *   leetcode 347 , 前 K 个高频元素
     *   使用小根堆 + map 保存频率
     *
     */
    public static void main(String[] args) {
        //topKFrequent(new int[]{4,1,-1,2,-1,2,3},2);
        System.out.println("a".compareTo("b"));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int num : nums){
            int amount = map.getOrDefault(num,0);
            amount++;
            map.put(num,amount);
        }
        // 前 K 个高频 ，所以使用小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (Integer  num :map.keySet()){
            if (queue.size()<k){
                queue.offer(num);
            }else {
                if ( map.get(num) > map.get(queue.element())){
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        int[] arr = new int[k];
        for (int i=0;i<k;i++){
            arr[i] = queue.poll();
        }
        return arr;
    }

    /**
     *  出现频率最高的前top K 单词
     */
    public List<String> topKFrequent(String[] words, int k) {
        if (words==null || words.length==0 || k == 0){
            return new LinkedList<>();
        }

        Map<String,Integer> map = new HashMap<>();
         int fre =0;
         for (String str : words){
             fre = map.getOrDefault(str,0);
             fre++;
             map.put(str,fre);
         }
         LinkedList<String> list = new LinkedList<>();
         PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
             @Override
             public int compare(String o1, String o2) {
                 return map.get(o1).equals(map.get(o2))? o2.compareTo(o1) : map.get(o1) - map.get(o2);
             }
         });

         for (String str : map.keySet()){
             if (queue.size() < k){
                 queue.offer(str);
             }else{
                 if (map.get(str) > map.get(queue.element())){
                     queue.poll();
                     queue.offer(str);
                 }
             }
         }
         int lengh = queue.size();
         for (int i =0;i<lengh;i++){
             list.addFirst(queue.poll());
         }
         return list;
    }
}
