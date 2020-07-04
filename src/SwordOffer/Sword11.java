package SwordOffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
 * 输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 */
public class Sword11 {
    //方法一 暴力解法，遍历数组 O（n）
    public int minArray(int[] numbers) {
        int length = numbers.length;
        int index = 0;
        for (index = 0; index < length - 1; index++) {
            if (numbers[index] > numbers[index + 1]) {
                return numbers[index + 1];
            }
        }
        index = 0;
        return numbers[index];

    }

    //  二分法，logN，选择数组中间的数flag,flag<
    //  循环二分法，，没做出来
    public int minArray1(int[] numbers) {

        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] < numbers[j]) {
                j = m ;
            } else if (numbers[m] > numbers[j]) {
                i = m+1;
            }else {
                j=j-1;
            }
        }
        return numbers[i];
    }


//        int length = numbers.length;
//        int indexMax = length-1;
//        int index = indexMax/2;
//        int indexMin = 0;
//        if (indexMin==indexMax){
//            return numbers[indexMin];
//        }
//        while(indexMin<=indexMax){
//            if (index==indexMax){
//                break;
//            }
//            if (numbers[index]<=numbers[index+1]){
//                indexMin = index+1;
//                index = (indexMax+indexMin)/2;
//            }else {
//                return numbers[index];
//            }
//        }
//        return numbers[0];


    /**
     * 练习一下，有序数组的二分查找
     */
    public static void main(String[] args) {

        System.out.println(new Sword11().select(new int[]{1,2,3,4,5,6,8},3));

    }
    //使用二分查找法定位某个元素，若存在返回数组下标，不存在返回-1；
    public int select(int[]numbers,int target){
        int index = -1;
        int minIndex = 0;
        int indexMax = numbers.length-1;

        while(true){
            index = (minIndex+indexMax)/2;
            if (numbers[index]==target){
                return index;
            }else if (index==minIndex){
                if (target == numbers[indexMax]){
                    return indexMax;
                }else {
                    return -1;
                }
            }else{
                if (target>numbers[index]){
                    minIndex = index;
                }else {
                    indexMax = index;
                }
            }
        }

    }

}


