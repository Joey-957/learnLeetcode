package Greedy;

import java.util.Stack;

/**
 * leecode 121 股票问题I：
 * <p>
 * leecode 122 卖股票问题,使用贪心策略，比较当天和第二天的差价，绝对递增则卖出
 * 因为连续追涨好多天的收益和再一直涨的期间每天买卖的效果是一样的，最终叠加相邻两天收益之和即为所求
 */
public class Greedy_122 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int length = prices.length;
        for (int i = 0; i < length; i++) {
            if (i < (length - 1) && prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }

        }
        return profit;
    }

    public int maxProfit1(int[] prices) {
        int profit = 0;
        int length = prices.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (prices[i] < prices[j]) {
                    int temp = prices[j] - prices[i];
                    profit = Math.max(temp, profit);
                }
            }

        }
        return profit;
    }

    //股票 121 问题，使用单调递减栈
    public int maxProfit3(int[] prices){
        int maxProfit = 0;
        int length = prices.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<length;i++){
            if(!stack.isEmpty()&&prices[i]>prices[stack.peek()]){
                maxProfit = Math.max(maxProfit,prices[i]-prices[stack.peek()]);
            }else{
                stack.push(i);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int p = new Greedy_122().maxProfit3(prices);
        System.out.println(p);

    }

}
