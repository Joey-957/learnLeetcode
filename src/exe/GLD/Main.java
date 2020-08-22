package src.exe.GLD;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int lengh = str1.length();
        int score = 0;
        for (int i=0;i<lengh;i++){
            if (str1.charAt(i) == str2.charAt(i)){
                score = score +20;
            }else{
                if (score==0){
                    continue;
                }else{
                    score -=10;
                }
            }
        }
        System.out.println(score);
    }
}
class main2{


    static int[] arrs;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[4];
        for(int i=0;i<4;i++){
            arr[i] = sc.nextInt();
        }
        if (arr[0]==arr[1] && arr[1]==arr[2] && arr[2]==arr[3] ){
            System.out.println(4* arr[0]);
        }


        Arrays.sort(arr); // 思路是 验证从（arr[0]，arr[3]）之间验证
        int soutInt = -1;
        //int fre = arr[4]- arr[0];


        boolean flag = false;

        int max = 0;  // 保留遍历最大值

         int des = 0; // 缺口量
          int ins = 0;  //  剩余量


        for(int i = arr[0]+1 ; i< arr[3];i++){

            des = 0;  // chusihua
            ins = 0;
            ///////
            des = (i - arr[0]) *2 + des;  // 第一种 一定是 缺少的

            //  (2)
            if (i > arr[1]){
                des = des + (i-arr[1])*2;
            }else if (i < arr[1]){
                ins = ins + (arr[1]-i);
            }
            // (3)
            if (i > arr[2]){
                des = des + (i-arr[2])*2;
            }else if (i < arr[2]){
                ins = ins + (arr[2]-i);
            }

            // (4)

            ins = ins + (arr[3]-i);

            if (des == ins){
                flag = true;
                int temp = 4*i;
                if (temp > max){
                    max = temp;
                }
            }

        }

        if (flag){
            System.out.println(max);
        }else{
            System.out.println(soutInt);
        }



        }



    }

class main3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[4];
        for(int i=0;i<4;i++){
            arr[i] = sc.nextInt();
        }
        if (arr[0]==arr[1] && arr[1]==arr[2] && arr[2]==arr[3] ){
            System.out.println(4* arr[0]);
        }


        Arrays.sort(arr); // 思路是 验证从（arr[0]，arr[3]）之间验证
        int soutInt = -1;
        //int fre = arr[4]- arr[0];
        int des = 0; // 缺口量
        int ins = 0;  //  剩余量

        boolean flag = false;

        int max = 0;  // 保留遍历最大值

        for(int i = arr[3] -1 ; i> arr[0] ;i--){

            des = 0;
            ins = 0;
            ins = ins + arr[3] - i;
            //
            if (arr[2]<i){
              des = des + (i-arr[2])*2;
            }else if (arr[2]>i){
               ins = ins + (arr[2] -i)*2;
            }

            if (arr[1]<i){
                des = des + (i-arr[1])*2;
            }else if (arr[1]>i){
                ins = ins + (arr[1] -i)*2;
            }

            des = des + (i-arr[0])*2;

            if (des == ins){
                //flag = true;
                int temp = 4*i;
                System.out.println(temp);
                return;
            }


        }
        if (flag){
            System.out.println(max);
        }else{
            System.out.println(soutInt);
        }



    }

}