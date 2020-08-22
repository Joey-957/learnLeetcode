package src.exe.WY;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amounts = scanner.nextInt();
        //int[] arr = new int[amounts];
        int cur = 0;
        int fre = 0;// 素数的频率
        for (int i =0;i<amounts;i++){
            cur = scanner.nextInt();
            fre = fre + primeAmounts(cur);
        }
        System.out.println(fre);
    }
    public static  int primeAmounts(int cur){
        if (cur < 2){
            return 0;
        }
        if (cur <=3){
            return 1;
        }

        return cur /2 ;
    }





//    public static  int primeAmounts(int cur){
//        if (cur<=1){
//            return 0;
//        }
//        if (cur ==3){
//            return 1;
//        }
//        if (cur ==5){
//            return 2;
//        }
//        if (cur ==7){
//            return 3;
//        }
//        return primeAmounts(cur -2) + 1;
//    }
}

class Main3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0;i<n;i++){
            int cn = sc.nextInt();
            int[] weights = new int[cn];
            for (int j =0;j<cn;j++){
                weights[j] = sc.nextInt();
            }
            System.out.println(solutions(weights));
        }
    }

    public static int ans;
    public static int solutions(int[] weight){
        ans = Integer.MAX_VALUE;
        solutions(weight,0,0,0,0);
        return ans;
    }
    public static void solutions(int[] weight,int id,int aweight,int bweight,int drop){
        if (id == weight.length){
            if (aweight == bweight){
                ans = Math.min(ans,drop);
            }
        }else{
            solutions(weight,id+1,aweight+ weight[id],bweight,drop);
            solutions(weight,id+1,aweight, weight[id]+bweight,drop);
            solutions(weight,id+1,aweight,bweight,drop+ weight[id]);
        }
    }
}
class main4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vexAmount = sc.nextInt();
        int edgAmount  = sc.nextInt();
        int[][] arr = new int[edgAmount][3];

        int[] arr1 = new int[edgAmount];

        for (int i = 0;i<edgAmount;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
            arr1[i] = arr[i][2];
        }
        Arrays.sort(arr1);
        int length = arr1.length;
        if (vexAmount==1){
            System.out.println(arr1[0]);
        }
        if (vexAmount==2) {
            System.out.println(arr1[1] - arr1[0]);
        }else{
            System.out.println(arr1[length] - arr1[0]);
        }

    }
}