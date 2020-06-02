package Sort;

/**
 * 集中排序的练习：冒泡排序、选择排序、插入排序、快速排序
 * 冒泡排序：每一次遍历将数组中的最大值逐渐交换到最右边，
 * 选择排序：最左侧是有序区，右侧是无序区，每次遍历找出无序区的最小值，放置有序区，
 * 插入排序：将第二个元素和第一个比，使之有序，然后将第三个元素与前面的有序区一起使之有序，以此类推
 * 未完待续，待补充。。。。。
 */
public class Sort {
    //1、冒泡排序
    private void BubbleSort(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {//外层循环是一次排序
            boolean swith = false;//设置表示，若这次排序没发生交换，则说明数组已经有序了，不必再排序了。
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swith = true;
                }
            }
            if (!swith) {
                break;
            }
        }
    }

    //2、简单选择排序
    private void selectionSort(int[] array) {
        int minNum = -1;
        int minAdd = 0;
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            minNum = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < minNum) {
                    minNum = array[j];
                    minAdd = j;
                }
            }
            temp = array[i];
            array[i] = minNum;
            array[minAdd] = temp;
        }
    }

    //直接插入算法
    private void insertionSort(int[] array) {
        int temp = 0;
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0) {
                if (array[j] < array[j - 1]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                } else {
                    break;//因为左侧是有序的，比最右边的大就不用比了
                }
                j--;
            }
        }
    }

    //希尔排序
    private int shellSort(int[] array) {
        int len = array.length;
        if (len == 0) {
            return 0;
        }
        int current, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                current = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > current) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = current;
            }
            gap /= 2;
        }
        return 0;
    }

    //xvyaozaixieyibian
    private int shellSort_my(int[] array) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        int current;
        int gap = length / 2;
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                current = array[i];
                int preindex = i - gap;
                while (preindex >= 0 && array[preindex] > current) {
                    array[preindex + gap] = array[preindex];
                    preindex = preindex - gap;
                }
                array[preindex + gap] = current;
            }
            gap = gap / 2;
        }
        return 0;
    }

    //归并排序


    public static void main(String[] argus) {
        Sort sort = new Sort();
        int[] test = new int[]{7, 6, 5, 4, 3, 2, 1};
        //sort.BubbleSort(test);
        //sort.selectionSort(test);
        //sort.insertionSort(test);
        sort.shellSort_my(test);

        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }
}

