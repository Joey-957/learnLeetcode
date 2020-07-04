package SwordOffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sworld03{
    //面试题03. 数组中重复的数字

    //暴力破解  时间复杂度是O（n^2），空间复杂度是O(1)
    public int findRepeatNumber(int[] nums) {
        int length = nums.length;
        int index = -1;
        for (int i=0;i<length;i++){
            for (int j=i+1;j<length;j++){
                if (nums[i]==nums[j]){
                    index = i;
                    break;
                }
            }
            if (index!=-1){
                break;
            }
        }
        return nums[index];
    }

    //方法二： 时间  nlogn ， 空间 O（1）

    public int findRepeatNumber2(int[] nums) {
        Arrays.sort(nums);
        int index = -1;
        for (int i=0;i<nums.length-1;i++){
            if (nums[i]==nums[i+1]){
                index =i;
                break;
            }
        }
        if (nums[nums.length-2]==nums[nums.length-1]){
            return nums[nums.length-1];
        }
        return nums[index];
    }

    //法三 ：哈希表  时间O（n）  空间  O（n）
    public int hashSet(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
                //set.add(nums[i]);
            }
            set.add(num);
        }
        return -1;
    }
}
