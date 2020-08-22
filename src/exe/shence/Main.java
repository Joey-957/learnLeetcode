package src.exe.shence;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        if (str1.length() != str2.length()){
            System.out.println("false");
            return;
        }

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
//        if (str1.length() == 2){
//            if (ch1[0] == ch1[1]&& ch2[0]==ch2[1] && ch1[0] == ch2[0])
//                System.out.println("true");
//                return;
//        }
        int fre = 0;

        for (int i = 0;i<ch1.length;i++){
            if (ch1[i] != ch2[i]){
                fre++;
                if (fre >2){
                    System.out.println("false");
                    break;
                }
            }
        }
        if (fre == 0){
            System.out.println("true");
            return;
        }
        if (fre != 2){
            System.out.println("false");
            return;
        }
        System.out.println("true");
    }
}
class Maon2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        List<Character> list = new LinkedList<>();
        boolean flag = true;
        for (int i=0;i<chars.length;i++){
            if (Character.isUpperCase(chars[i])){
                if (flag){
                  list.add(Character.toLowerCase(chars[i]));
                  flag = false;
                }else{
                    list.add('_');
                    list.add(Character.toLowerCase(chars[i]));
                }
                //list.add(chars[i]);
            }else{
                list.add(chars[i]);
            }

        }
        StringBuilder sb = new StringBuilder("");
        for (int i=0;i<list.size();i++){
            sb = sb.append(list.get(i));
        }
        System.out.println(sb.toString());
//        Character[] re = new Character[list.size()];
//        list.toArray(re);
//        System.out.println(Arrays.toString(re));
    }
}
class Main3{
    public static void main(String[] args) {
        Thread t = new Thread();

        String a = "a";
        System.out.println(a.compareTo("b"));
        System.out.println(a.compareTo("abd"));
        System.out.println(a.compareTo("aaa"));
        //
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<num;i++){
            stack.push(sc.nextInt());
        }
        while (sc.hasNext()){
            System.out.print(sc.nextInt() + " ");
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+ " ");
        }
    }
}