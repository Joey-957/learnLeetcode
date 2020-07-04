package SwordOffer;

public class Sword15 {
    //位运算  不会,  注意题目是无符号数，无符号右移>>>
    public int hammingWeight(int n) {
        int count =0;

        while(n!=0){
            if ((n&1)==1){
                count++;
            }
            n= n>>>1;
        }
        return count;
    }
}
