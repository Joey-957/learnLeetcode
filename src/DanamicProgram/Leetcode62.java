package src.DanamicProgram;

import java.util.Arrays;

/**
 * 机器人路径
 */
public class Leetcode62 {
    private int uniquePaths(int m,int n){
        int[][] dp = new int[m][n];
//        Arrays.fill(dp[0],1 );
//        for (int j = 0; j < dp.length;j++){
//             dp[j][0] = 1;
//        }
//        dp[0][0] = 0;


        for (int i = 0;i<dp.length;i++){
            for (int j =0;j<dp[0].length;j++){
                if (i==0 || j==0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
