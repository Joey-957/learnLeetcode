package src.SwordOffer;

/**
 * 剪绳子 -I
 */
public class Sworld14 {

    /**
     * 剪绳子 -I  ，找规律题
     */
    public int cuttingRope(int n) { // 将 n = 3a + b；
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }
        //if (b==2){
        return (int) Math.pow(3, a) * 2;
        //}
    }

    /**
     * 剪绳子 -I  ，找规律题
     *
     * ！！！！！！！！设置sum 为 long型  ， 相比上一题 n取得会比较大，所以存在大数溢出，会溢出
     *
     */

    public int cuttingRope_II(int n) {

        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int a = n / 3;
        int b = n % 3;
        long sum = 1;

        if (b == 0) {

            while (a>0) {
                sum = (sum*3)% 1000000007;
                a--;
            }
            return (int)sum;

            //return (int) (((long) Math.pow(3, a)) % 1000000007);


        }
        if (b == 1) {
            a--;
            while (a>0) {
                sum = (sum*3)% 1000000007;
                a--;
            }
            sum = (sum*4)% 1000000007;
            return (int)sum;
            //return (int) ((long) Math.pow(3, a - 1) * 4) % 1000000007;

        }

        while (a>0) {
            sum = (sum*3)% 1000000007;
            a--;
        }
        sum = (sum*2)% 1000000007;
        return (int)sum;
        // if (b==2){
        //return (int) (((long) Math.pow(3, a) * 2) % 1000000007);
        // }
    }

    public static void main(String[] args) {
        System.out.println(new Sworld14().cuttingRope_II(900
        ));
    }
}
