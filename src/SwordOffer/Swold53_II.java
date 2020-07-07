package src.SwordOffer;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 */
public class Swold53_II {
    //二分查找，优质解
    public int missingNumber(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left<=right){
            mid = left + (right-left)/2;
            if (nums[mid] == mid){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return  left;

    }


    //暴力法
    public int missingNumberII(int[] nums) {
        int length = nums.length;
        int i;

        for (i = 0; i < length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return i;

    }
}
