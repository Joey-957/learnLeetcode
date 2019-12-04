package Sort;
/**
 * 集中排序的练习：冒泡排序、选择排序、插入排序、快速排序
 *
 * 未完待续，待补充。。。。。
 *
 */
public class Sort {
    //冒泡排序
    private void BubbleSort(int[] array){
        int temp = 0;
        for(int i = 0;i<array.length-1;i++){
            boolean flag = false;
            for (int j = 0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }

    }

    public static void main(String[] argus){
        Sort sort = new Sort();
        int[] test = new int[]{4,3,2,1};
        sort.BubbleSort(test);
        for(int i = 0;i<test.length;i++){
            System.out.println(test[i]);
        }
    }
}

