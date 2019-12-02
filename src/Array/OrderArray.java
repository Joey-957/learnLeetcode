package Array;

/**
 * 有序数组的查找（二分查找）、添加、删除
 * 数组由小到大排列
 */
public class OrderArray {

    private int length = 0;
    private int[] array;

    public OrderArray(int max) {
        this.array = new int[max];
    }

    //(二分查找)查找一个数据项，成功返回数组下标，否则返回-1
    public int select(String elem) {
        int index = -1;
        int low = 0;
        int high = array.length - 1;
        return index;
    }


    //insert
    public void insert(int elem) {
        int index = 0;
        for (;index <= array.length - 1; index++) {
            if (elem < array[index]) {
                break;
            }
        }
        for (;index<=array.length-1;index++){

        }




    }
}
