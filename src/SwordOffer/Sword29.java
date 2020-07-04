package SwordOffer;

import java.util.LinkedList;
import java.util.List;

/**
 * 顺时针打印二维数组，然后返回数组
 *
 * error:list.toArray 返回的是Object数组
 *
 */
public class Sword29 {
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length; // m 行
        if (m == 0){
            return new int[0];
        }
        int minLeft = 0; // 矩阵最左的index标号
        int maxRight = matrix[0].length-1;  //矩阵最右边index标号
        int top = 0;
        int bottom = m-1;  //  矩阵的上标和小标
        int[] results = new int[m*(maxRight+1)];
        int index = 0;
        while (true){
            for (int i= minLeft;i<=maxRight;i++){
                results[index++] = matrix[top][i];
            }                                         //  从左至右
            if (++top>bottom){
                break;
            }
            for (int j = top;j<=bottom;j++){
                results[index++] = matrix[j][maxRight];
            }                                    //  从上到下
            if (minLeft>--maxRight){
                break;
            }
            for (int h=maxRight;h>=minLeft;h--){
                results[index++] = matrix[bottom][h];
            }
            if (--bottom<top){
                break;
            }
            for (int k=bottom;k>=top;k--){                //  error k<= top
                results[index++] = matrix[k][minLeft];
            }
            if (++minLeft>maxRight){
                break;
            }
        }
        return results;

    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        new Sword29().spiralOrder(a);
    }


}
