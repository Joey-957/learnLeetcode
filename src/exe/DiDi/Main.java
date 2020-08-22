package src.exe.DiDi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static long[] arr;
    private static int k=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        long[] arrFib = new long[amount*amount + 1];
        arrFib[0] = 0;
        arrFib[1] = 1;
        arrFib[2] = 1;
        for (int i=3;i<arrFib.length;i++){
            arrFib[i] = arrFib[i-1] + arrFib[i-2];
        }
        long[][] arrSout = new long[amount][amount];
        arr =arrFib;
        k = arrFib.length-1;
        cursionPrint(arrSout,0,0,amount-1,amount-1);

        //填充数字 ，然后打印 mm 矩阵
        for (int k=0;k<amount;k++){
            for (int j=0;j<amount;j++){
                System.out.print(arrSout[k][j]+" ");
            }
            System.out.println();
        }
    }

    public static void cursionPrint(long[][] matrix,int m0,int n0,int m1,int n1){
        //每次递归打印一层矩阵当
        if (m0 > m1 || n0 > n1){
            return;
        }

        if (m0 == m1){
            for (int i = n0;i<= n1;i++){
                matrix[m0][i] = arr[k--];
            }
            return;
        }
        if (n0 == n1){
            for (int i = m0;i <= m1;i++){
                matrix[i][n0] = arr[k--];
            }
            return;
        }


        for (int i = n0;i< n1;i++){
            matrix[m0][i] = arr[k--];
        }
        for (int i = m0;i< m1;i++){
            matrix[i][n1]= arr[k--];
        }
        for (int i = n1; i> n0;i--){

            matrix[m1][i] =arr[k--];
        }
        for (int i = m1;i > m0;i--){

            matrix[i][n0] = arr[k--];
        }
        cursionPrint(matrix,++m0,++n0,--m1,--n1);
    }
}

class Main2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            boolean[] flags = new boolean[10];
            List<int[]> list = new ArrayList<>();
            solution(list,flags,0,new int[3],n);
            System.out.println(list.size());
            for(int[] nums:list)
                System.out.println(nums[0] + " " + nums[1]);
        }
    }
    public static void solution(List<int[]> list,boolean[] flags, int index, int[] bytes, int target) {
        if(index == 3) {
            int num1 = bytes[0]*100 + bytes[1]*10 + bytes[2];
            int num2 = bytes[0]*100 + bytes[2]*10 + bytes[2];
            if((200*bytes[0]+10*bytes[1]+12*bytes[2]) == target)
                list.add(new int[]{num1,num2});
        } else {
            int i= 0;
            if(index == 0)
                i = 1;
            for(;i<=9;i++) {
                flags[i] = true;
                bytes[index] = i;
                solution(list,flags,index+1,bytes,target);
                flags[i] = false;
            }
        }
    }

}





 class Main1 {
         public static void main(String[] args) {
             Scanner sc = new Scanner(System.in);
             int n=sc.nextInt();
             int[][] marix=new int[n][n];
             int rows=0;int rowe=marix.length-1;
             int cols=0;int cole=marix[0].length-1;


             x=n*n;
             while(rows<=rowe&&cols<=cole){
                 solution1(marix,rows++,rowe--,cols++,cole--);
             }

             for (int i = 0; i <n ; i++) {
                 for (int j = 0; j <n ; j++) {
                     System.out.print(marix[i][j]+" ");
                 }
                 System.out.println();
             }

         }
         public static int x=0;
         public  static void solution1( int[][] marix,int rows ,int rowe,int cols,int cole) {

             if (rows == rowe) {//一行
                 while (cols <= cole) {

                     marix[rows][cols++]=getValue(x--);
                     // System.out.print(marix[rows][cols++] + " ");
                 }
             } else if (cols == cole) {//一列
                 while (rows <= rowe) {
                     // System.out.print(marix[rows++][cols] + " ");
                     marix[rows++][cols]=getValue(x--);
                 }
             } else {
                 int start = cols;
                 while (start <= cole) {

                     //   System.out.print(marix[rows][start++] + " ");
                     marix[rows][start++]=getValue(x--);
                 }
                 start = rows + 1;
                 while (start <= rowe) {
                     //  System.out.print(marix[start++][cole] + " ");
                     marix[start++][cole]=getValue(x--);
                 }
                 start = cole - 1;
                 while (start >= cols) {
                     //  System.out.print(marix[rowe][start--] + " ");
                     marix[rowe][start--]=getValue(x--);
                 }
                 start = rowe - 1;
                 while (start > rows) {
                     //  System.out.print(marix[start--][cols] + " ");
                     marix[start--][cols]=getValue(x--);
                 }

             }
         }


         private static int getValue(int n) {
             //递归终止条件
             if(n==1||n==2)
                 return 1;

             int a=1;
             int b=1;
             int c=1;
             for (int i = 3; i <=n ; i++) {
                 c=a+b;
                 a=b;
                 b=c;
             }

             return c;
         }
}

class  Main21{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> list = new ArrayList<>();
        for (char a = '1'; a <= '9'; a++) {
            for (char b = '0'; b <= '9'; b++) {
                for (char c = '0'; c <= '9'; c++) {
                    if (a != b && a != c && b != c) {
                        int abc = (a - '0') * 100 + (b - '0') * 10 + (c - '0');
                        int acc = (a - '0') * 100 + (c - '0') * 10 + (c - '0');
                        if ((abc + acc) == n){
                            list.add(abc + " " + acc);
                        }
                    }
                }
            }
        }
        System.out.println(list.size());
        list.forEach(s -> System.out.println(s));
    }
}

class Main45{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        long[] array = new long[n * n];
        array[0] = array[1] = 1L;
        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 2] + array[i - 1];
        }
        long[][] res = new long[n][n];
        int index = n * n - 1;
        for (int i = 0; i <= n / 2; i++) {
            for (int topp = i; topp < n - i; topp++) {
                res[i][topp] = array[index--];
            }
            for (int ri = i + 1; ri < n - i; ri++) {
                res[ri][n - i - 1] = array[index--];
            }
            for (int bottoms = n - i - 2; bottoms >= i; bottoms--) {
                res[n - i - 1][bottoms] = array[index--];
            }
            for (int le = n - i - 2; le >= i + 1; le--) {
                res[le][i] = array[index--];
            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != n - 1){
                    System.out.print(res[i][j] + " ");
                }else {
                    System.out.println(res[i][j]);
                }
            }
        }
    }
}




