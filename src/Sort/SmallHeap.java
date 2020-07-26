package src.Sort;

import java.util.Arrays;

/**
 *  小顶堆代码
 */
public class SmallHeap {
    public static int[] topN(int[] arr, int n) {
        /**
         * 构建堆积
         */
        int[] list = new int[n];
        System.arraycopy(arr, 0, list, 0, n);
        for (int i = 0; i < n; i++) {
            int t = i;
            while (t != 0 && list[parent(t)] > list[t]) {
                swap(list, t, t = parent(t));
            }
        }

        /**
         * 小顶堆
         */
        for (int i = n, len = arr.length; i < len; i++) {
            if (arr[i] >= list[0]) {
                // 置换栈顶
                list[0] = arr[i];
                // 调整栈顶
                int t = 0;
                while ((left(t) < n && list[t] > list[left(t)]) || (right(t) < n && list[t] > list[right(t)])) {
                    if (right(t) < n && list[right(t)] < list[left(t)]) {
                        swap(list, t, t = right(t));
                    } else {
                        swap(list, t, t = left(t));
                    }
                }
            }
        }
        return list;
    }

    /**
     * <description>对象交换</description>
     *
     * @param list
     * @param i
     * @param j
     * @author: ouyp
     * @since: Seeyon V7.0 SP2
     * @date: 2018年10月16日 下午4:56:33
     */
    private static void swap(int[] list, int i, int j) {
        int tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }
    /**
     * <description>父节点索引</description>
     *
     * @param i
     * @return
     * @author: ouyp
     * @date: 2018年10月16日 下午3:34:22
     */
    private static int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * <description>左孩子索引</description>
     *
     * @param i
     * @return
     * @author: ouyp
     * @date: 2018年10月16日 下午4:01:30
     */
    private static int left(int i) {
        return 2 * i + 1;
    }

    /**
     * <description>右孩子索引</description>
     *
     * @param i
     * @return
     * @author: ouyp
     * @date: 2018年10月16日 下午4:02:04
     */
    private static int right(int i) {
        return 2 * i + 2;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{56, 30, 71, 18, 29, 93, 44, 75, 20, 65, 68, 34};
        System.out.println("原始数组: ");
        System.out.println(Arrays.toString(arr));
        System.out.println("调整后数组: ");
        System.out.println(Arrays.toString(SmallHeap.topN(arr, 11)));
    }
}
