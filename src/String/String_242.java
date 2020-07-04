package String;

import java.util.Arrays;

public class String_242 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] str_s = s.toCharArray();
        char[] str_t = t.toCharArray();
        Arrays.sort(str_s);
        Arrays.sort(str_t);
        if(Arrays.equals(str_s,str_t)){
            return true;
        }else{
            return false;
        }
    }
    //哈希法
    public boolean isAbagram2(String s,String t){
        if (s.length()!=t.length()){
            return false;
        }
        int[] char_ = new int[26];
        for(int i=0;i<s.length();i++){
            char_[s.charAt(i)-'a']++;
            char_[t.charAt(i)-'a']--;
        }
        for (int num:char_
             ) {
            if (num!=0)
            return false;
        }
        return true;
    }
}
