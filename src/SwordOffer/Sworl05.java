package SwordOffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题05. 替换空格
 */
public class Sworl05 {

    // error, 输出是："[W, e, %, 2, 0, a, r, e, %, 2, 0, h, a, p, p, y, .]"

    public String replaceSpace(String s) {
          char[] array = s.toCharArray();
          int length=array.length;
          List<Character> list = new LinkedList<>();
          for (int i=0;i<length;i++){
              if (' ' == array[i]){
                  list.add('%');
                  list.add('2');
                  list.add('0');
                  continue;
              }
              list.add(array[i]);
          }
          return list.toString();
    }

    //借用一个备用数组
    public String replaceSpace1(String s) {
        char[] array = s.toCharArray();
        int length=array.length;
        char[] chars = new char[length*3];
        int size=0;
        for (int i=0;i<length;i++){
            if (' ' == array[i]){
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size] = '0';
                size++;
                continue;
            }
            chars[size] = array[i];
            size++;
        }
        //return chars.toString(); // error :方法使用错了！！
        return  new String(chars,0,size);
    }

    public static void main(String[] args) {
        String s = "we we we we";
        char[] array = s.toCharArray();
        int length=array.length;
        char[] chars = new char[length*3];
        for (int i=0,j=0;i<length;i++,j++){
            if (' ' == array[i]){
                chars[j++] = '%';
                chars[j++] = '2';
                chars[j] = '0';
                continue;
            }
            chars[j] = array[i];
        }
        //  error:字符数组转字符串的方法用错了，也应该使用 ： String string = new String(char[] chars,0,char.length)
        String sd = new String(chars,0,chars.length);

    }
}
