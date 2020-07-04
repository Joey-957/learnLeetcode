package src.SwordOffer;

import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 */
public class Swold40 {
    // 方法一：快排array+ 打印前k个元素,联系一下手写快排，写代码还是使用Arrays.sort（arr）
    public int[] getleastNumbers(int[] arr,int k){
        if (k==0){
            return new int[0];
        }
        int[] array = new int[k];
        Quick(arr);
        for (int i=0;i<k;i++){
            array[i] = arr[i];
        }
        return array;
    }

    //快速排序
    public void Quick(int[] arr){
        int left = 0;
        int right = arr.length-1;
        quickSort(arr,left,right);
    }
    public void quickSort(int[]arr,int left,int right){
        if (left>=right){
            return;
        }
        int index = getPivotindex(arr,left,right);
        quickSort(arr,left,index-1);
        quickSort(arr,index+1,right);

    }
    public int getPivotindex(int[]arr ,int leftIndex,int rightIndex){
        int pivot = arr[leftIndex];
        int left = leftIndex;
        int right = rightIndex;
        while(left!=right){
            while (left<right&&arr[right]>pivot){
                right--;
            }
            while (left<right&&arr[left]<=pivot){   // 不加等号会出错！！！！
                left++;
            }
            if (left<right){
                int t = arr[left];
                arr[left] = arr[right];
                arr[right] = t;
            }
        }
        int p = arr[leftIndex];
        arr[leftIndex] = arr[left];
        arr[left] = p;
        return left;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4,3,2,5,8,7,6,9};
        new Swold40().Quick(array);
        System.out.println(Arrays.toString(array));
    }

}
