package src.面试指南左程云.StringMy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 判断两个字符是否互为变形词
 *
 *  自己的思路 ：使用map
 */
public class 变形词 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        String str1 = null;
        String str2 = null;
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        sc.nextLine();
        str1 = sc.nextLine();
        str2 = sc.nextLine();
        if (isBx(str1,str2)){
            System.out.print("true");
        }else{
            System.out.print("false");

        }
    }
    public static boolean isBx(String str1,String str2){
        Map<Character,Integer> map = new HashMap<>();
        int length1 = str1.length();
        Character ch = null;
        int frequnce = 0;
        for (int i =0;i<length1 ;i++){
            ch = str1.charAt(i);
            if (map.containsKey(ch)){
                frequnce = map.get(ch);
                map.put(ch,frequnce + 1);
            }else{
                map.put(ch,1);
            }
        }

        int length2 = str2.length();
        if (length1 != length2){
            return false;
        }

        for (int i =0;i<length2;i++){
            ch = str2.charAt(i);
            if (map.containsKey(ch)){
                frequnce = map.get(ch);
                if (frequnce == 1){
                    map.remove(ch);
                }else{
                    frequnce--;
                    map.put(ch,frequnce);
                }
            }else{
                return false;
            }
        }
        return map.isEmpty();
    }
}
