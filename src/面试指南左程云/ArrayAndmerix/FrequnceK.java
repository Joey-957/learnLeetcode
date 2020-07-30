package src.面试指南左程云.ArrayAndmerix;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 数组中出现次数大于 n/k 的数
 *
 * tips: 使用哈希表保存
 */
public class FrequnceK {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        int k = sc.nextInt();
        int frequnce = amount/k;
        int[] arr = new int[amount];
        Map<Integer,Integer> map = new HashMap<>();
        int temp;
        int fre = 0;
        for (int i = 0; i < amount; i++) {
             temp = sc.nextInt();
             if (map.containsKey(temp)){
                 fre = map.get(temp);
                 map.put(temp,fre+1);
             }else{
                 map.put(temp,1);
             }
        }
        boolean flag = false;
        for (Integer key : map.keySet()){
            if (map.get(key)> frequnce){
                flag = true;
                System.out.print(key + " ");
            }
        }
        if (!flag){
            System.out.print(-1);
        }

    }


}
