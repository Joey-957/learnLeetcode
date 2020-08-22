package src.Sort;

import java.util.Arrays;

public class Merge {

    public static void main(String[] args) {
        int[] a= new int[]{4,3,2};
        new Merge().mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    private void mergeSort(int[] array){
        if (array==null||array.length<=1){
            return;
        }
        int[] newArray = new int[array.length];
        mergeSort(array,0,array.length-1,newArray);
    }

    private void mergeSort(int[] array,int left,int right,int[]newArray){
        if (left>=right){
            return;
        }
        //
        int mid = left +(right-left)/2;
        //
        mergeSort(array,left,mid,newArray);
        mergeSort(array,mid+1,right,newArray);
        //辅助数组
        for (int i = left; i <= right; i++){
            newArray[i] = array[i];
        }
        // 合并
        int i = left;
        int j = mid+1;
        int k = left;
        while (i <= mid && j <= right){
            if (newArray[i]<=newArray[j]){
                array[k++] = newArray[i++];
            }else {
                array[k++] = newArray[j++];
            }
        }
        while (i <= mid){               // 注意使用 while
            array[k++] = newArray[i++];
        }
    }
}
class MergeSort{
    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,1,5,6};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void mergeSort(int[] arr){
        if(arr == null || arr.length == 0){
          return;
        }
        int left = 0;
        int right = arr.length - 1;
        int[] newArray = new int[arr.length];
        mergeSort(arr,left,right,newArray);

    }

    private static void mergeSort(int[] arr,int left ,int right,int[] newArray){
        if (left >= right){
            return;
        }
        int mid = left + (right - left)/2;
        mergeSort(arr,left,mid,newArray);
        mergeSort(arr,mid + 1 ,right,newArray);
        for (int i = left;i<=right;i++){
            newArray[i] = arr[i];
        }
        // 合并
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i<=mid && j<= right){
            if (newArray[i] <= newArray[j] ){
                arr[k] = newArray[i];
                k++;i++;
            }else{
                arr[k] = newArray[j];
                j++;k++;
            }
        }
        while(i<=mid){
            arr[k++] = newArray[i++];
        }
    }
}