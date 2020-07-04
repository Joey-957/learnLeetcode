package src.SwordOffer;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，
 * 则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 *
 * !!!本题目要求返回int【】数组，则默认输入的n比较小返回的数都没有整数溢出
 *
 * 若考虑大数溢出问题，那么应该怎么做呢？
 *
 * 大树打印解法：
 *  1.表示大数的变量类型：
 *      ·无论是short/int/long ...任意变量类型，数字的取值范围都是有限的，因此大数的应用表示应该使用String
 *  2.生成数字的字符串集
 *      ·当使用int类型时，每轮可通过+1 生成下一个数字，而此方法无法应用到String上，并且String类型的数字进位操作效率低
 *      ·生成的列表实际上是n位 0-9 的全排列
 *
 *
 *
 *
 *
 */
public class Sword17 {

    //考虑整数溢出问题,int的取值范围是【-2^31,2^31-1】











    //结束函数Math.pow（）
    public int[] printNumbers(int n){
        int length = (int)Math.pow(10.0,n*1.0);
        int[] array = new int[length-1];
        for (int i=0;i<array.length;i++){
            array[i] = i+1;
        }
        return array;
    }


}
