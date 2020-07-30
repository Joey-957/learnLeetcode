package src.面试指南左程云;

/**
 *  快速排序算法  和 快速选择的练习
 *
 *
 *  快速选择使用了快排思想，找到切分过的index 后，即此时数组
 */

class MainMy{
    public static void main(String[] args) {
        int[] array = new int[]{7,1,0,6,9,5,3};
        QuickSort qc = new QuickSort();
        int[] re = qc.quickSort(array);


        int[] array2 = new int[]{7,1,0,6,9,5,3};
        int[] latestK = qc.getLeastNumber(array2,6);


    }
}

public class QuickSort {
    public int[] quickSort(int[] array){
        int length = array.length;
        int left = 0;
        int right = length - 1;
        sortRecursion(array,left,right);
        return array;
    }

    public void sortRecursion(int[] array ,int leftIndex, int rightIndex){ // 参数：数组、左边界 和右边界
        if (leftIndex >= rightIndex){
            return;
        }
        int mid = getPivot(array,leftIndex,rightIndex);
        sortRecursion(array,leftIndex,mid -1);
        sortRecursion(array,mid + 1,rightIndex);
    }

    public int getPivot(int[] array ,int left,int right){
        int pivot = array[left];
        int pivotIndex = left;
        while(left < right ){
            while(left < right && array[right] > pivot){
                right --;
            }
            while(left < right && array[left] <= pivot){
                left ++;
            }
            if (left < right){
                int temp = array[right];
                array[right] = array[left];
                array[left] = temp;
            }

        }
        //跳出循环时，此时 left == right 即 此时 left是 pivot值应该存放的位置
        int temp = array[pivotIndex];
        array[pivotIndex] = array[left];
        array[left] = temp;
        return left;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 快速选择
     * @return  返回int【】数组内最小的K个元素并封装成数组
     *
     */
    public int[] getLeastNumber(int[] array,int k){
        if (k==0){
            return new int[0];
        }else if (array.length <=k){
            return array;
        }
        int length = array.length;
        int left = 0;
        int right = length -1;
        partitionArray(array,left,right,k);
        int[] returnArray = new int[k];
        for (int i =0;i<k;i++){
            returnArray[i] = array[i];
        }
        return returnArray;
    }

    public void partitionArray(int[] arr,int leftIndex,int rightIndex,int k){
        if (leftIndex >= rightIndex){
            return;
        }
        int mid = getPivotIndex(arr,leftIndex,rightIndex);

        if (mid == k){
            return;
        }else if (mid < k){
            partitionArray(arr,mid +1,rightIndex,k);
        }else{
            partitionArray(arr,leftIndex,mid -1,k);
        }

    }

    private int getPivotIndex(int[] array,int leftIndex,int rightIndex){
        int pivot = array[leftIndex];
        int pivotIndex = leftIndex;
        while(leftIndex < rightIndex){
            while(leftIndex < rightIndex && array[rightIndex] > pivot){
                rightIndex--;
            }
            while(leftIndex < rightIndex && array[leftIndex] <= pivot){
                leftIndex++;
            }
            if (leftIndex < rightIndex){
                int temp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = temp;
            }
        }
        int temp = array[leftIndex];
        array[leftIndex] = pivot;
        array[pivotIndex] = temp;
        return  leftIndex;
    }
}
