package src.面试指南左程云;

import java.util.Stack;

/**
 * 单调栈
 */
public class Cd101 {

    /**
     * 1. leetcode 739、每日温度
     * 请根据每日 气温 列表，重新生成一个列表。
     * 对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
     * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
     *
     * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
     *
     * 分析 ：建立递减栈，每当有新的数据来时，和栈顶index对应元素作比较，如果大于栈顶元素 则栈顶元素 ，
     * 循环比较小则弹出，直到 栈顶index 对应的值 大于 新来的index对应值或者栈为空才能入栈，
     * 所以维护的是递减栈
     *
     */

    public static void main(String[] args) {
        new Cd101().dailyTemperatures(new int[]{73,74,75});
    }
    public int[] dailyTemperatures(int[] t){
        int length = t.length;
        int[] returnArray = new int[length];
        Stack<Integer> stackDec = new Stack<>();
        for (int i=0 ; i < length ; i++){
            int temp = t[i];
            while(!stackDec.isEmpty() && t[stackDec.peek()] <temp ){
                int preIndex = stackDec.pop();
                returnArray[preIndex] = i - preIndex;
            }
            stackDec.push(i);
        }
        while (!stackDec.isEmpty()){
            int i = stackDec.pop();
            returnArray[i] = 0;
        }
        return returnArray;
    }


    /**
     * 单调栈 左程云
     *  给定一个不含有重复值的数组 arr，
     *  找到每一个 i 位置左边和右边离 i 位置最近且值比 arr[i] 小的位置。返回所有位置相应的信息。
     *
     *  分析： 找左右 最近 小的值 ，所以维护递增栈
     */
    public int[][] newCode(int[] t){
        int length = t.length;
        int[][] arrays = new int[length][2];
        Stack<Integer> stack = new Stack<>();  // 大于栈顶index对应值入栈
        for (int i = 0 ;i < length ; i++){
            int temp = t[i];
            while(!stack.isEmpty() && temp < t[stack.peek()]){
                int index = stack.pop();
                arrays[index][1] = i;
            }
            if (stack.isEmpty()){
                arrays[i][0] = -1;
            }else{
                arrays[i][0] = stack.peek();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int index = stack.pop();
            arrays[index][1] = -1;
        }
        return arrays;

    }


}
