package src.SwordOffer;

/**
 *
 统计一个数字在排序数组中出现的次数。
 */
public class sword53 {
    //方法一、暴力求解  遍历有序数组
    public int search(int[] nums, int target) {
        int frequnce=0;
        //int length = nums.length;
        for (int num:nums) {
            if (num==target){
                frequnce++;
            }
        }

        return frequnce;
    }

    //二分查找法
    public int search2(int[] nums,int target){
        int freq = 0;
        int min = 0;
        int length = nums.length;
        int max = length-1;
        int targetIndex = -1;
        //判断数组为不为空
        if(length==0){
            return 0;
        }
        // 先找到target的index
        while(true){
            targetIndex = (min+max)/2;
            if (target==nums[targetIndex]){
                break;
            }else if(targetIndex==min){
                if (target==nums[max]){
                    targetIndex = max;
                    break;
                }else {
                    targetIndex = -1;
                    break;
                }
            }else if (target<nums[targetIndex]){
                max = targetIndex;
            }else {
                min = targetIndex;
            }
        }
        if (targetIndex!=-1){
            for (int i=targetIndex;i<nums.length;i++){
                    if (target==nums[i]){
                        freq++;
                    }else {
                        break;
                    }
            }
            for (int i=targetIndex;i>=0;i--){    //  数组是从0开始的！！！！！
                if (target==nums[i]){
                    freq++;
                }else {
                    break;
                }
            }
        }
        if (freq>0){
            return --freq;
        }
        return freq;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4};
        new sword53().search2(array,3);
    }
}
