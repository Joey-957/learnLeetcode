package src.SwordOffer;

/**
 * 左旋转字符串
 *
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *
 */
public class Swold58II {
    public String reverseLeftWords(String s, int n) {
        int length = s.length();
        if (n >= length){
            return s;
        }

        String subString = s.substring(0,n);
        String sb2 = s.substring(n,length);
        return sb2+subString;
    }
}
