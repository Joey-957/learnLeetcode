package src.DanamicProgram;

/**
 * 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 */
public class Leetcode64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length; // hang
        int n = grid[0].length; //lie
        //int[][] grid = new int[m][n];
        //int[][] grid = grid;
        for (int i = 0;i < m ; i++){
            for (int j = 0;j < n;j++){
                if (i==0 && j==0){
                    continue;
                }
                if (i==0){
                    grid[i][j] += grid[i][j-1];
                    continue;
                }
                if (j ==0){
                    grid[i][j] += grid[i-1][j];
                    continue;
                }
                grid[i][j] += Math.min(grid[i][j-1] ,grid[i-1][j]);
            }
        }
        return grid[m-1][n-1];
    }
}
