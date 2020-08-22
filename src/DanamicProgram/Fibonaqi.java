package src.DanamicProgram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 入门 01、
 * 斐波那契数列
 */
public class Fibonaqi {
    //自顶而下，备忘录
    public Integer fib(int n){
        Map<Integer,Integer> map = new HashMap<>();
        if (n==1 || n==2){
            return 1;
        }
        map.put(1,1);
        map.put(2,1);
        return recursion(map,n);
    }
    public Integer recursion(Map<Integer,Integer> map ,int n){
        if (n ==1 | n==2){
            return 1;
        }
        if (map.containsKey(n)){
            return map.get(n);
        }else{
            map.put(n,(recursion(map,n-1)+ recursion(map,n-2)));
            return map.get(n);
        }
    }
    //方法二：dp数组的迭代解法
    public int fibDP(int N){
        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= N ;i++){
            dp[i] = dp[i-1] + dp[i+1];
        }
        return dp[N];
    }

    /**
     * 以上仅涉及了 状态转移方程 和 重叠子问题
     * 02、凑零钱问题   最优子结构
     *
     * 本题目的 凑零钱是不考虑钱的数量的，张数不需要考虑。
     */

    public static void main(String[] args) {
        Fibonaqi f= new Fibonaqi();
        int[] arr = new int[]{2};
        int a = f.coinChange2(arr,3);
    }

    //方法1 暴力递归，超时
    public int coinChange2(int[] coins,int amount){
        if (amount < 0){
            return -1;
        }
        if (amount == 0){
            return 0;
        }
        int result = Integer.MAX_VALUE;
        int re =  recursion(coins,amount,result);
        if (re <=-1 || re == result){
            return  -1;
        }else{
            return re;
        }
    }
    public int recursion(int[] coins,int n,int result){
        if (n < 0){
            return -1;
        }
        if (n == 0){
            return 0;
        }

        for (int coin :coins){
            int temp = recursion(coins,n - coin,result);
            if (temp == -1){
                continue;
            }
            result = Math.min(result,temp + 1);
        }

        return result;
    }

    //方法二：DP
    /**
     * 1、定义状态： dp[i] : 凑出总价值i所需的最少数量
     */
    public int coinChange(int[] coins,int amount){
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount +1);//dp[i] 数组上的值等于 amount + 1意味没有办法凑出数值为 i 的零钱。
        dp[0] = 0;
        for (int i = 1;i<= amount;i++){
            for (int coin:coins){  // 注解 dp[index] = 数量 ，index对应amount ，值对应1最少硬币量
                if (i - coin >= 0 && dp[i - coin] != amount +1){
                    dp[i] = Math.min(dp[i],1+dp[i -coin]);
                }
            }
        }
        if (dp[amount] == amount + 1){
            dp[amount] = -1;
        }
        return dp[amount];
    }
}
