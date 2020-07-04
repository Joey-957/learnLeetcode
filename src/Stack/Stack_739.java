package Stack;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Stack;

/**
 *  每日温度
 */
public class Stack_739 {
    //暴力解法，重复遍历O（n2）
    public int[] dailyTemperatures(int[] T) {
        int[] array = new int[T.length];

        int num = 0;
        //Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            int temp = T[i];
            boolean flag = false;
            for (int j = i + 1, k = 1; j <=T.length - 1; j++) {
                if (T[j] > temp) {
                    num = k;
                    flag = true;
                    break;
                } else {
                    k++;
                }

            }
            if (flag==true) {
                array[i] = num;
            }else{
                array[i] = 0;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] t = new int[]{55,38,53,81,61,93,97,32,43,78};
        new Stack_739().dailyTemperatures(t);
    }

    /**
     *
     * @param T
     * @return int[]
     *
     * 单调栈的方法实现,递减栈,栈中保存数组下标
     */
    public int[] dayTemprare(int[] T){
        Stack<Integer> stack = new Stack<>();
        int[] array_temp = new int[T.length];
        for (int i=0;i<T.length;i++){
            while(!stack.isEmpty()&&T[stack.peek()]<T[i]){
                int temp = stack.pop();
                array_temp[temp] = i-temp;

            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int index = stack.pop();
            array_temp[index] = 0;
        }
        return array_temp;
    }
























}
