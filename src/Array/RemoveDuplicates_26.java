package Array;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicates_26 {
    /**
     * 版本一：用时太长
     *
     * @param nums
     * @return
     */
    private int removeDuplicates(int[] nums) {
        int return_num = nums.length;
        int flag = 119999;//存在边界条件
        for (int i = 0; i < nums.length; i++) {
            int goal = nums[i];
            int j = i + 1;
            for (; j < nums.length; j++) {
                if (nums[j] == goal) {
                    nums[j] = flag;
                } else {
                    break;
                }
            }
        }
        int flag_2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != flag) {
                //break; 结束本次循环和跳出循环的差别
                continue;
            }
            flag_2 = i + 1;
            for (; flag_2 < nums.length; flag_2++) {
                if (nums[flag_2] != flag) {
                    break;
                }
            }
            if (flag_2 == nums.length) {
                return_num = i;
                break;
            }
            nums[i] = nums[flag_2];
            nums[flag_2] = flag;
        }
        return return_num;
    }

    /**
     * 版本二，通过快慢指针，将数组内不重复的值全部移到数组的左侧
     *
     * @param
     * @return
     */
    private int removeDuplicates_2(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int q = 0, p = 1;
        while (p < nums.length) {
//            if(nums[p]==nums[q]){
//                p++;
//            }else{
//                q++;
//                nums[q] = nums[p];
//                p++;
//            }
            if (nums[p] != nums[q]) {
                q++;
                nums[q] = nums[p];
            }
            p++;
        }
        return q + 1;
    }

    public static void main(String[] argus) {
        int[] test = new int[]{1, 1, 1, 2, 2, 3, 3, 4, 5, 6, 6, 7, 8};
        int[] tt = new int[]{1, 2, 3};

        RemoveDuplicates_26 one = new RemoveDuplicates_26();
        int num = one.removeDuplicates(test);
        System.out.println(num);
        for (int i = 0; i <= num - 1; i++) {
            System.out.println(test[i]);
        }
    }
}
