package SwordOffer;

public class Sowld16 {

    /**
     * 答案：求解数值的整数次方，快速幂
     * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
     *
     * 当 int = -Integer.MAX_VALUE，那么 n = -n 会溢出 所以把n 改为long
     *
     *
     *
     *
     */
    public double myPow(double x, int n) {
        if(x==0){
            return 0.0;
        }
        long b = n;
        double res = 1.0;
        if (b<0){
            x = 1/x;
            b = -b;
        }
        while(b>0){
            if ((b&1)==1){
                 res *= x;
            }
            x *= x;
            b>>=1;
        }
        return res;
    }


    /**
     *
     * 总结：自己写的很失败，复杂度太高
     */
//    public double myPow(double x, int n) {
//
//        double temp = x;
//        if(n==0){
//            return 1.0;   //error :  不是 0.0
//        }
//        if(n>0){
//            while(n>1){
//                x = x*temp;   //error： 不应该是 x = x*x
//                n=n-1;
//            }
//        }else{
//            n=-n;
//            while(n>1){
//                x = x*temp;
//                n--;
//            }
//            return  1/x;   //error：忘记考虑分数
//        }
//        return x;
//    }
}
