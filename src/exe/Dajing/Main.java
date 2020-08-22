package src.exe.Dajing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strNumber = sc.nextLine();
        int amount = sc.nextInt();
        int length = strNumber.length();
        int baoliu = length- amount;
        int[] arr = new int[length];
        for (int i=0;i<length;i++){
            arr[i] = strNumber.charAt(i)-48;
        }
        int[] array = arr.clone();
        Arrays.sort(arr);
        Map<Integer,Integer> map = new HashMap<>();
        for (int k=0;k<baoliu;k++){
            int fre = map.getOrDefault(arr[k],0);
            fre= fre+1;
            map.put(arr[k],fre);
        }
        Stack<Integer> stack = new Stack<>();
        for (int j=length-1;j>=0;j--){
            int temp = array[j];
            if (map.containsKey(temp)){
                stack.push(temp);
                if (stack.size()==baoliu){
                    break;
                }
                int frequnce = map.get(temp);
                frequnce--;
                if (frequnce==0){
                    map.remove(temp);
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}

class Main2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        int day = sc.nextInt();
//        int[][] arr = new int[amount][2];
//        for (int i=0;i<amount;i++){
//            arr[i][0] = sc.nextInt();
//            arr[i][0] = sc.nextInt();
//        }
        Obj[] arr = new Obj[amount];
        for (int i =0;i<amount;i++){
            Obj obj = new Obj(sc.nextInt(),sc.nextInt());
            arr[i] = obj;
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
//        int kvalue = 0;
//        for (int m =0;m<amount;m++){
//            if (arr[m].day <day){
//                day = day - arr[m].day;
//                kvalue = kvalue + arr[m].value;
//            }else{
//                break;
//            }
//        }
//        System.out.println(kvalue);
    }

}
class Obj implements Comparable<Obj>{
    int day;
    int value;
    Obj(int value,int day){
        this.day = day;
        this.value = value;
    }

    @Override
    public int compareTo(Obj o1) {
        if(this.value < o1.value) {
            return -1;
        }else if(this.value > o1.value) {
            return 1;
        }
        return 0;
    }
    public String toString(){

        return new String(Integer.toString(this.value));
    }
}

class Main3{

}

class Main11 {
    public static void main(String[] args) {

        Scanner scc = new Scanner(System.in);
        int n=scc.nextInt();
        int days=scc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i <n ; i++) {
            arr[1][0]=scc.nextInt();
            arr[1][1]=scc.nextInt();
        }

        function(arr,days,0,0,0);
        System.out.println(res);
    }
    private static  int res=-1;
    private static void function(int[][] arr, int day,int starts,int curSum,int l) {
        if(starts<=day){
            if(res==-1)
                res=curSum;
            else {
                res= Math.max(res,curSum);
                return;
            }



        }

        for (int i = l; i <arr.length ; i++) {
            //  solution(arr,days,start ,curSum );
            if(starts<day)
                function(arr,day,starts+arr[i][1],curSum+arr[i][0],i+1);

        }
    }
}
class Test111{
    public static void main(String[] args) {
        int num1 = -1;
        int fre =0;
        double n = Math.sqrt(7);
        while(num1 !=0){

            if ((num1 & 1)==1){
                fre++;
            }
            num1 = num1 >>> 1;
        }
        System.out.println(fre);
    }
}
