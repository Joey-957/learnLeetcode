package src.exe;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t1m = 0,t1n = 0;
        int t2m = 0,t2n = 0;

        int d1m = 0,d1n = 0;
        int d2m = 0,d2n = 0;

        t1m = sc.nextInt();
        t1n = sc.nextInt();
        d1m = sc.nextInt();
        d1n = sc.nextInt();

        t2m = sc.nextInt();
        t2n = sc.nextInt();
        d2m = sc.nextInt();
        d2n = sc.nextInt();

        if (t1m <= t2m && t2m <=d1m && t1n <=t2n && t2n <=d1n){
            System.out.println(0);
            return;
        }
        if (d2m >=t1m && d2m <=d1m && d2n >=t1n && d2n <=d1n){
            System.out.println(0);
            return;
        }
        if (t2m >=t1m && d2m <=d1m || t2n>=t1n && t2n <=d1n ){
            System.out.println(0);
            return;
        }
        System.out.println(1);
    }
}

class mian{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];
        for (int i = 0;i<8;i++){
            arr[i] = sc.nextInt();
        }
        int leftx = Math.min(arr[0],arr[2]);
        int rightx = Math.max(arr[0],arr[2]);
        int leftty = Math.min(arr[1],arr[3]);
        int righty = Math.max(arr[1],arr[3]);
        if (((arr[4]>=leftx&&arr[4]<=leftty&&arr[4]<=righty)) || ((arr[5]>=leftx && arr[5]<=rightx)&&(arr[5]>=leftty&&arr[5]<=righty))){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}

class Main4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        char[] chars = str1.toCharArray();
        int length = chars.length;
        StringBuffer sb = new StringBuffer();
        boolean flag = false;
        for (int i=0;i<length;i++){
            if ('0'<=chars[i]&& chars[i]<='9'){
                flag = true;
                sb.append(chars[i]);
            }
            if ('-'==chars[i]&& !flag){
                sb.append(chars[i]);
                flag = true;
            }
        }
        System.out.println(sb.toString());
    }
}

class Main5{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fre = sc.nextInt();
        int[] arr = new int[fre];
        for (int i=0;i<fre;i++){
            arr[i] = sc.nextInt();
        }
        sort(arr);

    }
    public static void sort(int[] arr){
        sort1(arr,0,arr.length-1);
    }
    public static void sort1(int[] arr,int lo,int hi){
        if (lo >=hi){
            return;
        }
        int j  = partition(arr,lo,hi);
        for (int item :arr){
            System.out.print(item+ " ");
        }
        System.out.println();
        sort1(arr,lo,j-1);
        sort1(arr,j+1,hi);
    }
    private static int partition(int[] a,int lo,int hi){
        int i = lo,j = hi+1;
        while(true){
            while (a[++i] <a[lo]){
                if(i==hi){
                    break;
                }
            }
            while (a[--j]>a[lo]){
                if (j==lo){
                    break;
                }
            }
            if(i>=j){
                break;
            }
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
        int t = a[lo];
        a[lo] = a[j];
        a[j] = t;
            return j;
        }
    }

    class quickSort{
        public static void main(String[] args) {
            int[] arr = new int[]{25,15,21,47,84,27,68,35,84};
            quickSort(arr,0,arr.length-1);
        }
        public static void quickSort(int[]arr,int leftIndex,int rightIndex){
            if (leftIndex >= rightIndex){//一定要带等号
                return;
            }
            int mid = getPivot(arr,leftIndex,rightIndex);
            sout(arr);
            System.out.println();
            quickSort(arr,leftIndex,mid-1);
            quickSort(arr,mid+1,rightIndex);
        }
        public static void sout(int[] arr){
            for (int num : arr){
                System.out.print(num + " ");
            }
        }
        public static int getPivot(int[] arr,int left,int right){
            int pivoit = arr[left];
            int pivotIndexx = left;
            while (left < right){
                while (left < right && pivoit < arr[right]){
                    right--;
                }
                while (left < right && pivoit >=arr[left]){
                    left++;
                }
                if (left <right){
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }
            }
            int temp = arr[pivotIndexx];
            arr[pivotIndexx] = arr[left];
            arr[left] = temp;
            return left;
        }
    }
