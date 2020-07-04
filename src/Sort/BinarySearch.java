package src.Sort;

/**
 * 联系一下二分查找
 */
public class BinarySearch {

    public int binarySearch(int[]array, int target){
        int left = 0;
        int right = array.length-1;
        int mid = -1;

        while(left<=right){

            mid = left + (right-left)/2;  //!!  注意更新 mid的值

            if (array[mid]==target){
                return mid;
            }else if (array[mid]<target){
                left = mid+1;

            }else {
                right = mid-1;
            }
        }
        return -1;
    }

    /**
     * 验证，存在等于target，则返回target的下标index
     *      不存在返回-1；
     */
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7};
        System.out.println(new BinarySearch().binarySearch(a,6));
    }
}
