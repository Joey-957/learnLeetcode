package Array;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]

 */
public class TwoSum_1 {
    /**
     * 方法一、两边循环暴力破解，时间复杂度是O（n^2）
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int amount = nums.length;
        int start = 0;
        int start2=0;
        int flag = 0;
        while(start<=amount-1){
            start2=start+1;
            while(start2<=amount-1){
                if(nums[start]+nums[start2]==target){
                    flag=1;
                    break;
                }
                start2++;
            }
            if(flag==1){break;}
            start++;
        }
        int[] resolution={start,start2};
        return resolution;
    }

    /**
     * 方法二、哈希表（空间换时间）,遍历两次数组
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<=nums.length-1;i++){
            map.put(nums[i],i);
        }
        int end;
        for(int j=0;j<nums.length;j++){
            end = target-nums[j];
            if(map.containsKey(end)&&map.get(end)!=j){
                return new int[]{j,map.get(end)};
            }
        }
        throw new IllegalArgumentException("no solution");
    }

    /**
     * 方法三、哈希表（空间换时间）,遍历一次数组
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_3(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0;i<nums.length;i++){
            int component = target - nums[i];
            if (map.containsKey(component)){
                return new int[]{map.get(component),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("no solution");
    }

}
