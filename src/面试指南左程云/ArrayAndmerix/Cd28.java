package src.面试指南左程云.ArrayAndmerix;

import java.util.Scanner;

/**
 *  在数组中找到局部最小的数字
 */
public class Cd28 {
    private int sout = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amounts = sc.nextInt();
        if (amounts == 1){
            System.out.println(sc.nextInt());
            return;
        }
        int[] arr = new int[amounts];
        for (int i = 0;i<amounts;i++){
            arr[i] = sc.nextInt();
        }
        int start = 0;
        int end = arr.length-1;
        int index = start + (end - start);
        recursion(arr,start,end,index);
    }
    public static void recursion(int[] arr,int start,int end,int index){

    }
}

class Main2{
}
