package src.SwordOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 */
public class Swold39 {

    //方法一：使用 哈希表，暴力破解
    public int majorityElement(int[] nums) {
        int length = nums.length;
        if(length==1){
            return nums[0];
        }
        int flag = length/2;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<length;i++){
            int temp = nums[i];
            if(map.containsKey(temp)){
                int fre = map.get(temp);
                if (++fre>=flag){
                    return temp;
                }
                map.put(temp,fre);

            }else{
                map.put(temp,1);
            }
        }
        return -1;
    }

    /**
     *
     * 还有其他的解法，比如数组排序法：将数组排序后数组中间的数必为众数
     * 最优解法是：摩根投票法，初始时假设数组第一位是众数，票数记作1其他记作-1，当vote 清零时，将剩余数组的第一位数据记所众数，直到数组为最后一位
     *  若题设不能保证数组中一定会有众数，则需要在随后遍历数组检验一下·。
     */
    public int majorityElement2(int[] nums) {
        int length = nums.length;
        int vote = 0;
        int x = nums[0];
        for(int i=0;i<length;i++){
            if (nums[i]==x){
                vote++;
            }else{
                vote--;
            }
            if (vote==0&&(i+1)<length){
                x = nums[i+1];
            }
        }
        return x;
    }
}







