package SwordOffer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 */
public class Sword04 {
    /**
     * 在此类矩阵中，左下角元素和右上角元素有特殊性，称为标志数
     * 例如把左下角的元素记作flag，
     * flag>target,那么target一定在行的上方，不用再管flag所在行，flag标记上一行
     * flag<target，那么target 一定在flag的右边，flag右移动一列
     *    =  则找到了
     *    边界溢出则返回false
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
//        int lengthY = matrix.length;  //矩阵的行数
//        int lengthX = matrix[0].length; // 矩阵的列数

        int i = matrix.length-1;
        int j = 0;
        //boolean flag = false;
        while(i>=0&&j<matrix[0].length){
            if (matrix[i][j]>target){
                i--;
            }else if (matrix[i][j]<target){
                j++;
            }else {
                return true;
            }
        }
        return false;
    }


}
