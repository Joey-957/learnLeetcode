package src.SwordOffer;

/**
 * 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 *  考察对位运算的灵活运用
 */
public class Swold65 {
    public int add(int a, int b) {
        while (b!=0){
            int c = (a&b)<<1; // 进位
            a = a^b;
            b = c;
        }
        return a;
    }

}
