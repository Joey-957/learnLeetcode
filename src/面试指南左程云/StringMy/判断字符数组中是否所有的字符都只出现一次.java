package src.面试指南左程云.StringMy;

import java.util.Scanner;

public class 判断字符数组中是否所有的字符都只出现一次 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount  = sc.nextInt();
        char[] chars = new char[amount];
        String str1 = sc.next();
        chars = str1.toCharArray();
        boolean flag = isUnique(chars);
    }
    public static  boolean isUnique(char[] chars){
        if (chars == null){
            return true;
        }
        boolean[] map = new boolean[256];
        for (int i =0 ;i<chars.length;i++){
            if (map[chars[i]]){
                return false;
            }
            map[chars[i]] = true;
        }
        return true;
    }
}
