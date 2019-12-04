package Array;

/**
 * 版本一、先使用冒泡排序，在使用双指针将不重复数据移到数组的左边
 */
public class RemoveElem_27 {
    private int removeElement(int[] nums, int val) {
        if (nums.length == 1) {
            if (nums[0] == val) {
                return 0;
            }
            return 1;
        }
        //冒泡排序
        int temp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }

        int j = 0, k = 0;
        for (; j < nums.length; j++) {
            if (nums[j] == val) {
                break;
            }
        }
        k = j;
        j--;
        boolean flag = false;
        while (k < nums.length) {
            if (nums[k] != val) {
                j++;
                nums[j] = nums[k];
                flag = true;
            }
            k++;
        }
        if (!flag) {
            return j + 1;
        }
        return j + 1;
    }

    /**
     * 方法二：双指针,快指针用做判断是否和val值相等，慢指针负责填充值以及返回
     */
    private int removeElement_2(int[] nums, int val) {
//        if (nums.length == 1 && nums[0] == val) {
//            return 0;
//        }
        int i =0,j=0;
        while(j<nums.length){
            if(nums[j]!=val){
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] argus) {
        RemoveElem_27 one = new RemoveElem_27();
        int[] test = new int[]{2,2,3};
        int k = one.removeElement_2(test, 2);
        System.out.println("k"+k);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }

}
