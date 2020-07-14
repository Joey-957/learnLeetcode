package src.SwordOffer;

import java.util.Scanner;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的 数位之和 大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *
 */
public class Sworld13 {
    //计算数位和，例如‘123’ 得到的结果是 6
    private static void sum(){
        Scanner scanner = new Scanner(System.in);
        while(!scanner.hasNext("#")){   //单独输入‘#’ 就停止了
            int sum = 0;
            int number = scanner.nextInt();
            while(number / 10 !=0){
                sum = sum + number % 10;
                number = number /10;
            }
            sum = sum + number;
            System.out.println(sum);
        }
    }

    /**
     *
     * 标准答案解法：
     *   本题 1 <= n,m <= 100
     *   本题的数位增量公式,: x 的数位和是 SX ， 那么 x +1 的数位和可能是  SX -8 或者是 SX +1 ；
     *
     */
    int m,n,k;
    boolean[][] visited;

    public int movingCount(int m,int n,int k){
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0,0,0,0);
    }

    public int dfs(int i,int j,int si,int sj){
        if (i >= m || j>= n || k < si + sj || visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i+1,j,(i+1)%10 !=0? si+1:si-8,sj) + dfs(i,j+1,si,(j+1)%10 != 0? sj+1 : sj-8);
    }


    public static void main(String[] args) {
        sum();
    }
}
