package src.exe;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0;i<5;i++){
            int temp = sc.nextInt();
            if (temp < 0){
                System.out.println(-1);
                return;
            }else{
                arr[i] = temp;
            }
        }
        int j = 0;
        map.put(1,arr[j++]);
        map.put(5,arr[j++]);
        map.put(10,arr[j++]);
        map.put(50,arr[j++]);
        map.put(100,arr[j]);
        int amount  = sc.nextInt();
        if (amount<= 0){
            System.out.println(-1);
        }
        int fre = 0;//找钱的数量
        int cur = 0;
        while(amount > 0){
            if(amount >= 100 && map.get(100)>0){
                amount = amount -100;
                cur = map.get(100);
                cur = cur -1;
                map.put(100,cur);
                fre++;
                continue;
            }
            if(amount >= 50 && map.get(50)>0){
                amount = amount -50;
                cur = map.get(50);
                cur = cur -1;
                map.put(50,cur);
                fre++;
                continue;
            }if(amount >= 10 && map.get(10)>0){
                amount = amount -10;
                cur = map.get(10);
                cur = cur -1;
                map.put(10,cur);
                fre++;
                continue;
            }if(amount >= 5 && map.get(5)>0){
                amount = amount -5;
                cur = map.get(5);
                cur = cur -1;
                map.put(5,cur);
                fre++;
                continue;
            }
            if(amount >= 1 && map.get(1)>0){
                amount = amount -1;
                cur = map.get(1);
                cur = cur -1;
                map.put(1,cur);
                fre++;
            }
        }
        if (amount == 0){
            System.out.println(fre);
        }else{
            System.out.println(-1);
        }

    }
}


//   4399  k 频率问题

//class Main333{
//    public int[][] StirngTopK(List<String> list){
//
//        Map<String,Integer> map = new HashMap<>();
//
//        int fre = 0;
//
//        for(String str : list){
//
//            fre = map.getOrDefault(str,0);
//
//            map.put(str,++fre);
//
//        }
//
//        PriorityQueue<Ip> p = new PriorityQueue<Ip>((ip1, ip2)->{return ip1.fre-ip2.fre;
//
//    ​});
//        for (String str1 : map.keySet()){
//            Ip ip = new Ip(str1,map.get(str1));
//            if (p.size()<k) {
//                p.add(ip);
//            }else{
//                p.poll();
//                p.offer(ip);
//            }
//        }
//
//
//
//    }
//
//    class Ip{
//
//        String ip;
//
//        int fre ;
//
//        Ip(String ip,int fre){
//
//            this.ip = ip;
//
//            this.fre = fre;
//
//        }
//
//    }
//}