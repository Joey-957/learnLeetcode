package src.exe.YFD;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Map map = new HashMap();
        map.put(null,1);
        System.out.println(map.get(null));


        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();//数组m 行
        int[][] arr = new int[m][2];
        for (int i = 0;i<m;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int max = -1;
        for (int i=0;i<m;i++){
            max = max < arr[i][1]? arr[i][1]:max;
        }

        int[][] array  =new int[m][max];
        int temp1 = 0;
        int temp2 = 0;
        for (int i =0;i<m;i++){
            temp1 = arr[i][0] -1;
            temp2 = arr[i][1] -1;
            for (int j = temp1;j<=temp2;j++){
                array[i][j] = 1;
            }
        }

        int k = 0;
        int maxK = 0;
        for (int i=0;i<max;i++){
            for (int j = 0;j<m;j++){
                if (array[j][i]==1){
                    k++;
                }
            }
            maxK = maxK < k? k:maxK;
            k=0;
        }
        System.out.println(maxK-1);
    }
}

class Main2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        int[][] arr = new int[m][2];
        for(int i=0;i<m;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int amount = 0;
        for(int i=0;i<m-1;i++){
            amount += arr[i][0];
        }

        System.out.println(amount);
    }
}
