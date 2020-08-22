package src.exe.Meituan;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Mian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        String pause = sc.nextLine();
        while(amount>0){
            String name = sc.nextLine();
            isLegel(name);
            amount--;
        }

    }
    private static void isLegel(String string){
        char[] arr = string.toCharArray();
        int length = arr.length;
        if (length<2){
            System.out.println("Wrong");
            return;
        }

        if (!(Character.isUpperCase(arr[0]) || Character.isLowerCase(arr[0]))){
            System.out.println("Wrong");
            return;
        }
        //boolean hasChar = false;
        boolean hasNumber = false;
        for (int i=0;i<length;i++){
            boolean f = Character.isLetter(arr[i]);

            if (!(Character.isDigit(arr[i]) || Character.isUpperCase(arr[i]) || Character.isLowerCase(arr[i]))){
                System.out.println("Wrong");
                return;
            }
//            if (Character.isUpperCase(arr[i]) || Character.isLowerCase(arr[i])){
//                hasChar = true;
//            }
            if (Character.isDigit(arr[i])){
                hasNumber = true;
            }
        }
        if (hasNumber){
            System.out.println("Accept");
        }else{
            System.out.println("Wrong");
        }
    }
}

class Main3{
    private static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        int[] arrWeight  = new int[amount];
        for (int i=0;i<amount;i++){
            arrWeight[i] = sc.nextInt();
        }
        int fre = amount;
        arr = arrWeight;
        while(fre > 0){
            fre--;
            int index = sc.nextInt();
            index--;
            function(index);
        }
    }
    public static void function(int index){
        int weight = 0;
        arr[index]  = 0;
        int i=0;
        while (i<arr.length){
            int temp=0;
            while(i<arr.length && arr[i]!=0 ){
                temp += arr[i];
                i++;
            }
            weight = weight > temp ? weight:temp;
            i++;
        }
        System.out.println(weight);
    }
}

class Main33{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weights = new int[n];
        int[] orders = new int[n];
        for(int i=0;i<n;i++)
            weights[i] = sc.nextInt();
        for(int i=0;i<n;i++)
            orders[i] = sc.nextInt();
        long[] sums = new long[n];
        sums[0] = weights[0];
        for(int i=1;i<n;i++)
            sums[i] = sums[i-1] + weights[i];
        for(int i=0;i<n;i++) {
            for(int j=orders[i];j<sums.length;j++) {
                if(sums[j] == 0) break;
                sums[j] -= sums[orders[i]-1];
            }
            sums[orders[i]-1] = 0;
            System.out.println(findMax(sums));
        }
    }
    public static long findMax(long[] sums) {
        long max = sums[0];
        for(int i=0;i<sums.length;i++)
            max = Math.max(max,sums[i]);
        return max;
    }

}
class Main2{
    public static class Node {
        public int profit;
        public int idx;
        public Node(int profit, int idx) {
            this.profit = profit;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nn = sc.nextInt();
        int mm = sc.nextInt();
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.profit - o2.profit);
        for(int i=0;i<nn;i++) {
            Node node = new Node(sc.nextInt()+2*sc.nextInt(),i+1);
            if(queue.size()<mm)
                queue.add(node);
            else {
                if(node.profit>queue.peek().profit) {
                    queue.poll();
                    queue.add(node);
                } else if(node.profit == queue.peek().profit) {
                    if(node.idx < queue.peek().idx) {
                        queue.poll();
                        queue.add(node);
                    }
                }
            }
        }
        int[] ans = new int[mm];
        for(int i=0;i<mm;i++)
            ans[i] = queue.poll().idx;
        Arrays.sort(ans);
        for(int i=0;i<ans.length;i++) {
            if(i != ans.length-1)
                System.out.print(ans[i]+" ");
            else
                System.out.println(ans[i]);
        }
    }

}