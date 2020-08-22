package src.Sort;

import java.util.Arrays;

/**
 * 每次将一个数字插入一个有序的数组里，成为一个长度更长的有序数组，有限次操作以后，数组整体有序。
 * 所以 插入时 从数组元素第二个开始
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,1,5,6};
        insetSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insetSort(int[] arr){
        int length = arr.length;
        int temp = 0;
        for (int i=1;i<length;i++){
            int j = i;
            while(j > 0){
                if (arr[j] < arr[j-1]){
                    temp  =arr[j];
                    arr[j] = arr[j-1];
                    arr[j -1] = temp;
                }else{
                    break;
                }
                j--;
            }
        }
    }
}
