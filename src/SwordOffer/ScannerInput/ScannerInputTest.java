package src.SwordOffer.ScannerInput;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ScannerInputTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] sizes = new int[size];
        int i=0;
        while (scanner.hasNext()){
            sizes[i++] = scanner.nextInt();
            if (i>=size){
                System.out.println(Arrays.toString(sizes));
            }
        }
        System.out.println(Arrays.toString(sizes));


        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map map = new Hashtable();
        map.put("a",1);
        System.out.println(map.size());
    }
}
