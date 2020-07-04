package SwordOffer;

import java.util.Arrays;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 *
 *
 * 优质解法：双指针 解法
 *
 *        再加上二分判断
 *
 */
public class Sworld57 {

        public int[] twoSum2(int[] nums, int target) {
        int length = nums.length;
        int[] array = new int[2];
        int left = 0;
        int right = length-1;
        int mid = left+(right-left)/2;
        while (nums[mid]>target){
            right = mid;
            mid = left+(right-left)/2;

        }

        int leftIndex = 0;
        int rightIndex = right;
        while (leftIndex!=rightIndex){
            if (nums[leftIndex]+nums[rightIndex]>target){
                rightIndex--;
            }else if (nums[leftIndex]+nums[rightIndex]<target){
                leftIndex++;
            }else {
                array[0] = nums[leftIndex];
                array[1] = nums[rightIndex];
                return array;
            }
        }
        return array;
    }










//    //暴力法，双重循环遍历  ,超时
//    public int[] twoSum(int[] nums, int target) {
//        int length = nums.length;
//        int[] array = new int[2];
//        for (int i=0;i<length;i++){
//            for (int j=i+1;j<length;j++){
//                if (nums[i]+nums[j]==target){
//                    array[0] = nums[i];
//                    array[1] = nums[j];
//                    return array;
//                }
//            }
//        }
//        return array;
//    }
//
//    // 折半判断 ,还是超时
//    public int[] twoSum2(int[] nums, int target) {
//        int length = nums.length;
//        int[] array = new int[2];
//        int left = 0;
//        int right = length-1;
//        int mid = left+(right-left)/2;
//        while (nums[mid]>target){
//            right = mid;
//            mid = left+(right-left)/2;
//            length = right;
//        }
//
//
//        for (int i=0;i<length;i++){
//            for (int j=i+1;j<length;j++){
//                if (nums[i]+nums[j]==target){
//                    array[0] = nums[i];
//                    array[1] = nums[j];
//                    return array;
//                }
//            }
//        }
//        return array;
//    }



}
