package src.Sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,1,5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] arr){
        int length = arr.length;
        boolean flag = false;
        for (int i = 0;i < length ;i++){
            flag = true;
            for (int j = 0;j<length - 1 - i;j++){
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
    }
}
