package src.面试指南左程云.ArrayAndmerix;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 顺时针方向转动矩阵90°
 *
 * 空间复杂度 O（n^2），很简单
 * reverse2 使用的是 空间复杂度 O（n）
 */
public class Matrix90 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = m;
        int[][] matrix = new int[m][n];
        for (int i = 0;i< m;i++){
            for (int j =0 ;j < n;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int[][] ma = reverseMatrixfun(matrix,m);
        printMatrix(ma,m,n);
    }
    public static int[][] reverseMatrixfun(int[][] matrix,int m){
        reverseMatrix(matrix,0,0,m-1,m-1);
        return matrix;
    }

    private static void reverseMatrix(int[][]matrix,int tm,int tn,int dm ,int dn){
        if (tm > dm){
            return ;
        }
        int fre = dm - tm;
        int temp;
        for (int i = 0 ;i < fre ;i++){
            temp = matrix[tm][tn + i];
            matrix[tm][tn + i] = matrix[dm -i][tn];   // 注意不是[dm +i]
            matrix[dm - i][tn] = matrix[dm][dn - i];
            matrix[dm][dn - i] = matrix[tm + i][dn];
            matrix[tm + i][dn] = temp;

        }
        reverseMatrix(matrix,tm +1,tn+1,dm-1,dn-1);
    }

    private static void turn(int[][] matrix , int m){
        int temp = 0;
        for (int i = 0; i < m -1 ;i++){
            temp = matrix[i][m-1-i];
            //matrix[i][m-1-i] = matrix[][]
        }

    }

    private static int[][] reverseMatrix(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[][]ma = new int[m][n];
        for (int i = 0 ;i < m;i++){
            for (int j = 0;j< n;j++){
                ma[j][m-i-1] = matrix[i][j];
            }
        }
        return ma;
    }
    private static void printMatrix(int[][] matrix,int m,int n){
        for (int i = 0;i < m; i++){
            for (int j = 0;j < n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
























































    // 快排残党
     public static void quickSort(int[] arr){
        int length = arr.length;
        int leftIndex = 0;
        int rightIndex = length -1;
        recursion(arr,leftIndex,rightIndex);
     }

     public static void recursion(int[] arr ,int leftIndex,int rightIndex){
        if (leftIndex >= rightIndex){  //有 =
            return;
        }
        int mid = pivot(arr,leftIndex,rightIndex);
        recursion(arr,leftIndex,mid -1);
        recursion(arr,mid + 1,rightIndex);

     }

     public static int pivot(int[] arr,int leftIndex,int rightIndex){
        int pivot = arr[leftIndex];
        int pivotindex = leftIndex;
         while(leftIndex < rightIndex){
             while (leftIndex < rightIndex && arr[rightIndex] > pivot){
                 rightIndex--;
             }
             while (leftIndex < rightIndex && arr[leftIndex] <= pivot){  // 注意符号
                 leftIndex++;
             }
             if (leftIndex < rightIndex){
                 int temp = arr[leftIndex];
                 arr[leftIndex] = arr[rightIndex];
                 arr[rightIndex] = temp;
             }
         }
         int temp = arr[leftIndex];
         arr[leftIndex] = pivot;
         arr[pivotindex] = temp;
         return leftIndex;
     }

}
