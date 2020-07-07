package src.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 *  包含两道题
 *
 *  剑指 Offer 56 - I. 数组中数字出现的次数
 *  一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *
 */
public class Sworld56_I_II {
    //做题思路 a^a = 0; a^ 0 = a
    public int[] singleNumbers(int[] nums) {
        int mask = 0;
        for (int num : nums) {
            mask = mask ^ num;
        }
        int index = 1;
        while ((index & mask) == 0) {
            index <<= 1;
        }
        int a = 0;
        int b = 0; //!!!!!!!!!!!!!!!!!  不能是1
        for (int n : nums) {
            if ((n & index) == 0) {
                a = (a ^ n);
            } else {
                b = (b ^ n);
            }
        }
        int[] array = new int[]{a, b};
        return array;

    }


    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     */

    public static void main(String[] args) {

        int a = new Sworld56_I_II().singleNumber2(new int[]{1,2,2,2,9,9,9});
        System.out.println(a);
    }


    // 剑指offer 解法

    /**
     *
     * 该解法具有普遍性，若 数组中一个数字只出现一次其他数组出现奇数次 比如 7此 依然可以用此法
     *  若 数组中一个数字只出现一次其他数组出现偶数次，那么可以用异或法，有两个数字出现一次 异或分组法，两数异或 找到不同位，然后该index
     *   对整个数组 轮流异或，根据 1 0 分组
     */
    public int singleNumber2(int[] nums) {//本算法同样适用于数组nums中存在负数的情况
        if(nums.length==0) return -1;//输入数组长度不符合要求，返回-1;
        int[] bitSum = new int[32];//java int类型有32位，其中首位为符号位
        int res=0;
        for(int num:nums){
            int bitMask=1;//需要在这里初始化，不能和res一起初始化
            for(int i=31;i>=0;i--){//bitSum[0]为符号位
                //这里同样可以通过num的无符号右移>>>来实现，否则带符号右移(>>)左侧会补符号位，对于负数会出错。
                //但是不推荐这样做，最好不要修改原数组nums的数据
                if((num&bitMask)!=0) bitSum[i]++;//这里判断条件也可以写为(num&bitMask)==bitMask,而不是==1
                bitMask=bitMask<<1;//左移没有无符号、带符号的区别，都是在右侧补0
            }
        }
        for(int i=0;i<32;i++){//这种做法使得本算法同样适用于负数的情况
            res=res<<1;
            res+=bitSum[i]%3;//这两步顺序不能变，否则最后一步会多左移一次
        }
        return res;
    }







    // 只能想到暴力法
    public int singleNumber(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        int temp = 0;
        for (int num:nums){
            if (map.containsKey(num)){
                temp = map.get(num);
                map.put(num,++temp);
            }else {
                map.put(num,1); // 1 是频率
            }
        }
        for (Integer num:map.keySet()){
            if (map.get(num)==1){
                return num;
            }
        }
        return -1;
    }


}