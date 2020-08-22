package src.SwordOffer;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
 * 输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 */
public class Sword11 {
    //方法一 暴力解法，遍历数组 O（n）
    public int minArray(int[] numbers) {
        int length = numbers.length;
        int index = 0;
        for (index = 0; index < length - 1; index++) {
            if (numbers[index] > numbers[index + 1]) {
                return numbers[index + 1];
            }
        }
        index = 0;
        return numbers[index];

    }

    //  二分法，logN，选择数组中间的数flag,flag<
    //  循环二分法，，没做出来
    public int minArray1(int[] numbers) {

        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] < numbers[j]) {
                j = m ;
            } else if (numbers[m] > numbers[j]) {
                i = m+1;
            }else {
                j=j-1;
            }
        }
        return numbers[i];
    }
/**
 *  qiaoqi
 */
public int minArray2(int[] numbers) {


    if(numbers.length==1){
        return numbers[0];
    }
    int left = 0;
    int right = numbers.length -1;
    int index = right;
    while(left < right){
        index = left + (right - left)/2;
        if(numbers[right] < numbers[index]){
            left = index + 1 ;
        }else if(numbers[right] > numbers[index]){
            right = index ;
        }else{
            --right;
        }
    }
    return left;
}


    /**
     * 练习一下，有序数组的二分查找
     */
    public static void main(String[] args) {

        System.out.println(new Sword11().binarySort(new int[]{1,2,3,4,5,6,8},-1));
        System.out.println(new Sword11().minArray2(new int[]{3,3,3,1}));
    }
    private int binarySort(int[] arr,int target){
        int left =0;
        int right = arr.length-1;
        int middle = 0;
        while(left <= right){
            middle = left + (right - left)/2;
            if (arr[middle] == target){
                return middle;
            }else if (arr[middle]> target){
                right = middle -1;
            }else if(arr[middle] < target){
                left = middle +1;
            }
        }
        return  -1;
    }






    //使用二分查找法定位某个元素，若存在返回数组下标，不存在返回-1；

    /**
     *
     *  太麻烦
     */
    public int select(int[]numbers,int target){
        int index = -1;
        int minIndex = 0;
        int indexMax = numbers.length-1;

        while(true){
            index = (minIndex+indexMax)/2;
            if (numbers[index]==target){
                return index;
            }else if (index==minIndex){
                if (target == numbers[indexMax]){
                    return indexMax;
                }else {
                    return -1;
                }
            }else{
                if (target>numbers[index]){
                    minIndex = index;
                }else {
                    indexMax = index;
                }
            }
        }

    }

}


