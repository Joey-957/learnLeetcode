package src.Sort;

import java.util.Arrays;

public class Merge {

    public static void main(String[] args) {
        int[] a= new int[]{5,4,7,8,2,1,9,12};
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
        if (i<=mid){
            array[k++] = newArray[i++];
        }


    }




}
