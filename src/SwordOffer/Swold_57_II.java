package src.SwordOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 *
 *
 */
public class Swold_57_II {

    // 滑动窗口
    public int[][] findContinuousSequence(int target) {
        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {
                // 记录结果
                int[] arr = new int[j-i];
                for (int k = i; k < j; k++) {
                    arr[k-i] = k;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }

public static void main(String[] args) {
    List<Integer> list = new LinkedList<>();
    List<Integer> list2 = new ArrayList<>();
    list.add(1);
    list.add(2);
    list2.add(1);
    list2.add(2);
    System.out.println(Arrays.toString(list.toArray()));
    System.out.println(Arrays.toString(list2.toArray()));
    new Swold_57_II().findContinuousSequence(9);
}

}
