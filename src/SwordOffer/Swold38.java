package src.SwordOffer;

import java.util.*;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 即 字符串的全排列:分为字符可重复或者不重复
 *
 * char[] 字符数组 转化成字符串使用 String.valueOf（String str）  或者 new String（String str）
 *
 *  除了使用 set在结果集上降重，还能使用剪枝法
 */
public class Swold38 {

    public LinkedList<String> listAll = null;  //  error:原本没赋值
    public Set<String> set = new HashSet<>();


    public String[] permutation(String s) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        if (length==0){
            return new String[0];
        }
        boolean[] used = new boolean[length];

        LinkedList<Character> listIn = new LinkedList<>();
        recursion(listIn,charArray,used);

        listAll = new LinkedList<>(set);
        return listToString(listAll);

    }


    public void recursion(LinkedList<Character> linkedList,char[] charArray,boolean[] used){
            if (linkedList.size()==charArray.length){
                char[] c = listToChar(linkedList);
                String str = String.valueOf(c);
                set.add(str);
                return;
            }

            for (int i=0;i<charArray.length;i++){
                if (!used[i]){

                    linkedList.add(charArray[i]);
                    used[i] = true;
                    recursion(linkedList,charArray,used);
                    used[i] = false;
                    linkedList.removeLast();
                }
            }
    }

    public String[] listToString(LinkedList<String> listAll){
        int length = listAll.size();
        String[] strings = new String[length];
        int i = 0 ;
        for (String str:listAll){
            strings[i++] = str;
        }
        return strings;
    }

    public char[] listToChar(LinkedList<Character> list){
        int length = list.size();
        char[] charArray = new char[length];
        int i=0;
        for (char c:list){
            charArray[i++] = c;
        }
        return charArray;
    }

    public static void main(String[] args) {
        String str = "aac";
        String[] strings = new Swold38().permutation(str);
        System.out.println(Arrays.toString(strings));


    }
}

class function2{
    public LinkedList<String> listAll = new LinkedList<>();  //  error:原本没赋值
    //public Set<String> set = new HashSet<>();


    public String[] permutation(String s) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        if (length==0){
            return new String[0];
        }
        boolean[] used = new boolean[length];

        LinkedList<Character> listIn = new LinkedList<>();
        // 必须排序！！
        Arrays.sort(charArray);
        recursion(listIn,charArray,used);

        //listAll = new LinkedList<>(set);
        return listToString(listAll);

    }


    public void recursion(LinkedList<Character> linkedList,char[] charArray,boolean[] used){
        if (linkedList.size()==charArray.length){
            char[] c = listToChar(linkedList);
            String str = String.valueOf(c);
            listAll.add(str);
            return;
        }

        for (int i=0;i<charArray.length;i++){
            if (i>0&&charArray[i]==charArray[i-1]&&!used[i-1]){
                continue;
            }
            if (!used[i]){

                linkedList.add(charArray[i]);
                used[i] = true;
                recursion(linkedList,charArray,used);
                used[i] = false;
                linkedList.removeLast();
            }
        }
    }

    public String[] listToString(LinkedList<String> listAll){
        int length = listAll.size();
        String[] strings = new String[length];
        int i = 0 ;
        for (String str:listAll){
            strings[i++] = str;
        }
        return strings;
    }

    public char[] listToChar(LinkedList<Character> list){
        int length = list.size();
        char[] charArray = new char[length];
        int i=0;
        for (char c:list){
            charArray[i++] = c;
        }
        return charArray;
    }
}
