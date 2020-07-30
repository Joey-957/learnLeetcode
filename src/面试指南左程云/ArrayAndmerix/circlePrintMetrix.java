package src.面试指南左程云.ArrayAndmerix;

import java.util.Scanner;

/**
 *  01、转圈打印矩阵
 */
public class circlePrintMetrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0;i < m;i++){
            for (int j = 0;j < n;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        // 矩阵 matrix 完成赋值

        if (m == 1){
            for (int i =0;i<n;i++){
                System.out.print(matrix[0][i] + " ");
            }
            return;
        }
        if (n == 1){
            for (int i = 0;i<m;i++){
                System.out.print(matrix[i][0] + " ");
            }
            return;
        }

        cursionPrint(matrix,0,0,m-1,n-1);
    }
    public static void cursionPrint(int[][] matrix,int m0,int n0,int m1,int n1){
        //每次递归打印一层矩阵当
        if (m0 > m1 || n0 > n1){
            return;
        }


        if (m0 == m1){
            for (int i = n0;i<= n1;i++){
                System.out.print(matrix[m0][i] + " ");
            }
            return;
        }
        if (n0 == n1){
            for (int i = m0;i <= m1;i++){
                System.out.print(matrix[i][n0] + " ");
            }
            return;
        }


        for (int i = n0;i< n1;i++){
            System.out.print(matrix[m0][i] + " ");
        }
        for (int i = m0;i< m1;i++){
            System.out.print(matrix[i][n1] + " ");
        }
        for (int i = n1; i> n0;i--){

            System.out.print(matrix[m1][i] + " ");
        }
        for (int i = m1;i > m0;i--){
//            if (n0==n1){
//                break;
//            }
            System.out.print(matrix[i][n0] + " ");
        }
        cursionPrint(matrix,++m0,++n0,--m1,--n1);
    }
}
