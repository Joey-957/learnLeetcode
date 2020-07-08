package src.SwordOffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 滑动窗口的最大值
 *
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class Swold59_I {

    public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length ==0 || k == 0){
                return new int[0];
            }
            int leftIndex = 0;
            int rightIndex = leftIndex + k - 1;
            int endIndex= nums.length-1;
            int temp = 0;
            int maxNum = 0;
            List<Integer> list = new ArrayList<>();
            while(rightIndex<=endIndex){
                temp = leftIndex;
                maxNum = nums[leftIndex];
                while(temp<=rightIndex){

                    if (maxNum<nums[temp]){
                        maxNum = nums[temp];
                    }
                    temp++;
                }
                list.add(maxNum);
                rightIndex++;
                leftIndex++;
            }
            int[] array = new int[list.size()];
            for (int i = 0;i<array.length;i++){
                array[i] = list.get(i);
            }
        return array;
    }

    /**
     * 使用双向队列 维持一个递减队列
     *
     */
    public int[] maxSlidingWindowII(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < k; i++) { // 未形成窗口
            while(!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for(int i = k; i < nums.length; i++) { // 形成窗口后
            if(deque.peekFirst() == nums[i - k]) deque.removeFirst();
            while(!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }

}
