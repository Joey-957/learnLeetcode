package src.SwordOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理.
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 *
 */
public class Swold58 {

    // 官方答案 ，对字符串的处理不熟练
    public String reverseWords(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s, i + 1, j + 1).append(" "); // 添加单词
            while(i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("sdf");
        System.out.println(sb);
    }

    public String reversWords(String s){
        char[] array = s.toCharArray();
        int length  = array.length;
        int[] temp = new int[length];
        int leftIndex = 0;
        int end = 0;  // 数组的左边界
        int rightIndex = length -1;


        LinkedList<Character> list = new LinkedList<>();


        while(end <= rightIndex){
            if(array[rightIndex]==' '){
                rightIndex--;
            }else{
                //isChar = true;
                leftIndex = rightIndex;
                while(leftIndex>=end && array[leftIndex]!=' '){
                    leftIndex--;
                }
                leftIndex++;
                //if(leftIndex == end){

                    for(int g= leftIndex;g<=rightIndex;g++){
                        list.add(array[g]);
                    }
                    list.add(' ');
                    rightIndex = --leftIndex;
//                }else{
//
//                }

            }
        }
        if(list.size()>1 && list.getLast()==' '){    //只输入 ' ' 就 gg了
            list.removeLast();
        }

        int i = list.size();
        StringBuilder sb = new StringBuilder();
        while(i>0){
            sb.append(list.removeFirst());
            i--;
        }
        return sb.toString().trim();
    }

}
