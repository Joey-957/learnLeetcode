package src.exe.BliBli;

import java.time.chrono.IsoChronology;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Main t =new Main();
        System.out.println(t.IsValidExp("}}}"));
    }
    public boolean IsValidExp (String s) {
        // write code here
        char[] chars = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        char temp ;
        for (char ch :chars){
            if (ch=='('){
                stack.push(ch);
            }
            if (ch=='['){
                stack.push(ch);
            }
            if (ch=='{'){
                stack.push(ch);
            }
            if (ch==')'){
                if (stack.size()==0){
                    return false;
                }
                if ('(' != stack.element()){
                    return false;
                }else{
                    stack.poll();
                }
            }
            if (ch=='}'){
                if (stack.size()==0){
                    return false;
                }
                if ('{' != stack.element()){
                    return false;
                }else{
                    stack.poll();
                }
            }
            if (ch==']'){
                if (stack.size()==0){
                    return false;
                }
                if ('[' != stack.element()){
                    return false;
                }else{
                    stack.poll();
                }
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
class Main3{
    public static void main(String[] args) {
        Main3 m = new Main3();
        m.GetCoinCount(200);
    }
    public int GetCoinCount (int N) {
        // write code here
        if (N ==1024){
            System.out.println(0);
        }
        int amount = 1024 - N;
        int fre = 0;
        while(amount>=64){
            amount = amount -64;
            fre++;
        }
        while(amount>=16){
            amount = amount -16;
            fre++;
        }
        while(amount>=4){
            amount = amount -4;
            fre++;
        }
        while(amount>=1){
            amount = amount -1;
            fre++;
        }

        System.out.println(fre);
        return fre;
    }
}
