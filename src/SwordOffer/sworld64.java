package SwordOffer;

public class sworld64 {

    int sum = 0;
    public int sumNums(int n) {
        boolean x =  n>1&&sumNums(n-1)>0;
        sum +=n;
        return sum;

    }
}
