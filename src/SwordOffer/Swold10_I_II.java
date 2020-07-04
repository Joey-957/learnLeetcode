package SwordOffer;

import java.util.HashMap;
import java.util.Map;

public class Swold10_I_II {

    //斐波那契数列
    public int fib(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        int[] array = new int[n+1];
        array[0] = 0;
        array[1] = 1;
        int i;
        for (i=2;i<=n;i++){
            array[i] = array[i-2]+array[i-1];
        }
        return array[i-1];


    }

//    public static void main(String[] args) {
//        System.out.println(new Swold10_I_II().fib(2));
//    }

    // 青蛙上楼梯问题
    // 方法一：递归法即暴力解法  ,超出时间限制
    public int numWays(int n) {
        if(n==0){
            return 1;
        }
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        return  (fib(n-1)+fib(n-2))%1000000007;

    }


    //方法二：暴力解法+备忘录
    public int numWays2(int n) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        map.put(1,1);
        if(n<2){
            return map.get(n);
        }else {
            int val = function(map,n);
            return val%1000000007;
        }

    }

    public int function(Map<Integer,Integer> map,int n){
        if (map.containsKey(n)){
            return map.get(n);
        }else{
            int value = function(map,n-1)+function(map,n-2);
            map.put(n,value);
        }
        return map.get(n);
    }
    //方法三：动态规划
    public int numWays3(int n) {
        if (n<=1){
            return 1;
        }
        int[] array = new int[n+1];
        array[0] = 1;
        array[1] = 1;
        int i;

        for (i =2;i<=n;i++){
            array[i] = (array[i-1]+array[i-2])%1000000007;
        }
        return array[--i];
    }


}
