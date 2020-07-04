package src.Sort;

import java.util.Arrays;
import java.util.Vector;

/**
 * 快排
 */
public class QuickSort {

    public int[] sort(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        quickSort(nums, left, right);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = recursion(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);

    }

    public int recursion(int[] nums, int left, int right) {
        int pivot = nums[left];
        int leftIndex = left;
        int rightIndex = right;
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && nums[rightIndex] > pivot) {
                rightIndex--;
            }
            while (leftIndex < rightIndex && nums[leftIndex] <= pivot) {
                leftIndex++;
            }
            if (leftIndex < rightIndex) {
                int t = nums[leftIndex];
                nums[leftIndex] = nums[rightIndex];
                nums[rightIndex] = t;
            }
        }

        int temp = nums[leftIndex];
        nums[leftIndex] = nums[left];
        nums[left] = temp;
        return leftIndex;

    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] array = sort.sort(new int[]{4, 3, 5, 2, 6, 7, 1, 8, 9,0});
        System.out.println(Arrays.toString(array));
    }

}


class tryAgain1{

    public int[] quickSor(int[] array){
        int length = array.length;
//        if (length==0){
//            return  null;             //   没有必要
//        }
        int left =0;
        int right = length-1;
                                                      //int mid = getPivot(array,left,right);
        sortRecursion(array,left,right);
        return array;
    }

    public void sortRecursion(int[] array,int leftIndex,int rightIndex){
        if (leftIndex>=rightIndex){
            return;                                             // 数组为空或者 只有一个元素时，进入递归立刻返回！！
        }
        int mid = getPivot(array,leftIndex,rightIndex);
        sortRecursion(array,leftIndex,mid-1);
        sortRecursion(array,mid+1,rightIndex);
    }

    public int getPivot(int[] array,int left,int right){
        int pivot = array[left];
        int pivotIndex = left;

        while(left<right){
            while (left<right&&array[right]>pivot){
                right--;
            }
            while (left<right&&array[left]<=pivot){
                left++;
            }
            if(left<right){
                int temp = array[right];
                array[right] = array[left];
                array[left] = temp;
            }
//            int temp = array[pivotIndex];
//            array[pivotIndex] = array[left];                 ！！！ 不能写在这里
//            array[left] = temp;
        }
        int temp = array[pivotIndex];
        array[pivotIndex] = array[left];
        array[left] = temp;
        return left;                               // 不能返回leftIndex  注意和left的区别
    }


    public static void main(String[] args) {
        int[] array = new int[]{3,4,2,5,1,6,7,8,9,0};
        int[] array2 = new tryAgain1().quickSor(array);
        System.out.println(Arrays.toString(array2));
    }


}
class Tryagin2{
    public static void main(String[] args) {
        int[] array = new int[]{4,5,3,6,2,7,0,8,1,9};
        Tryagin2 t = new Tryagin2();
        t.sort(array);
        System.out.println(Arrays.toString(array));


        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.remove(3);
        System.out.println(vector.get(1));

    }
    public void sort(int[] array){
        int length = array.length;
        int left = 0;
        int right = length-1;
        quickSort(array,left,right);

    }
    private void quickSort(int[] array,int left,int right){
        if (left>=right){
            return;
        }
        int mid = getPivote(array,left,right);
        quickSort(array,left,mid-1);
        quickSort(array,mid+1,right);

    }

    private int getPivote(int[] array,int left,int right){
        int index = left;
        int pivote = array[index];
        while (left<right){
            while (left<right&&array[right]>pivote){
                right--;
            }
            while (left<right&&array[left]<=pivote){
                left++;
            }
            if (left<right){
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        int temp  = array[index];
        array[index] = array[left];
        array[left] = temp;
        return left;
    }
}
