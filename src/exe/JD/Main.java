package src.exe.JD;

//import com.sun.org.apache.xpath.internal.operations.String;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        float result =  recursion(n);
        String str = String.format("%.4f",result);
        System.out.println(str);
    }
    private static  float recursion(int n){
        if (n <= 0){
            return 0;
        }
        return  (float) (recursion(n-1) + (1.0/(5*(2*n-1))-1.0/(5*2*n)));
        //return f;
    }
}

class Main2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.println(Character.isLetter('A'));
        Long l = 1L <<32;
        System.out.println(l + 2);
        int num = (int)9999999999L;

        StringBuilder sb = new StringBuilder("1234");
        StringBuilder sb1 = sb.deleteCharAt(0);
        String str1 = "abcd";
        String str2 = str1.substring(0,1);
        String str3 = str1.substring(0,1)+ str1.substring(2,4);

        int fre = 0;
        int cur =0;
        for (int i = num1;i<num2;i++){

            fre += toStringB(i);
        }
        System.out.println(fre);
    }
    public static int toStringB(int i){
        //String str1 = new String("sdf");
        String str1 = String.valueOf(i);
        StringBuilder sb = new StringBuilder(str1);
        int length = sb.length();
        int fre = 0;
        for (int j=0;j<length;j++){

            StringBuilder sb1 = sb.deleteCharAt(i);//?????
            Integer t = Integer.parseInt(sb1.toString());
            String ss = t.toString();
            StringBuilder ss1 = new StringBuilder(ss);
            if (huiwen(ss1)){
                if (susu(ss1)){
                    fre++;
                }
            }
        }
        return fre;
    }

    public static boolean huiwen(StringBuilder sb) {
        String sb1 = sb.reverse().toString();
        for (int i = 0;i<sb1.length();i++){
            if (sb.charAt(i)!=sb1.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public static boolean susu(StringBuilder sb) {
        int num = Integer.parseInt(sb.toString());
        if (num<2){
            return false;
        }
        int r = (int) Math.sqrt(num);
        for (int i=2;i<=r;i++){
            if (num%i ==0){
                return false;
            }
        }
        return true;
    }
}

class Mian{
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

    }
}