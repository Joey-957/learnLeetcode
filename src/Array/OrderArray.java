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
    public int select(int elem,int[] array) {
        int index = -1;
        int low = 0;
        int high = array.length - 1;

        while(low!=high){
            int component = (low+high)/2;
            if (array[component]==elem){
                index = component;
                break;
            }
            if(array[component]<elem){
                low = component+1;
            }else{
                high = component-1;
            }
        }
        if (array[low]==elem){
            index = low;
        }
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
        for (int k = array.length-1;index<k;k++){
            array[k+1] = array[k];
        }
        array[index] = elem;
    }

    public static void main(String[] argus){

        OrderArray orderArray = new OrderArray(4);
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        int targt = 4;
        System.out.println(orderArray.select(targt,array));


    }
}
