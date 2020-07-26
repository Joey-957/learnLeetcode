package src.面试指南左程云;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 生成窗口最大值数组
 */
public class CD15 {
}

class T{
    public static void main(String[] asd){
        Scanner sc = new Scanner(System.in);
        int window = 0;
        int fre = sc.nextInt();
        int[] array = new int[fre];
        window = sc.nextInt();
        int i=0;
        while(fre > 0){
            fre--;
            array[i++] = sc.nextInt();
        }
        Deque<Integer> queue = new LinkedList<>();
        int[] results = windowFunction(queue,array,window);
        for(int num:results){
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static int[] windowFunction(Deque<Integer> queue,int[] array,int window){
        if(array == null || window < 1 || array.length < window){
            return null;
        }
        int[] res = new int[array.length - window +1];
        int index = 0;
        for(int i =0;i<array.length;i++){
            while(!queue.isEmpty() && array[queue.peekLast()] <= array[i]){
                queue.pollLast();
            }
            queue.addLast(2);
            if(queue.peekFirst() == i - window){  //  过期 下标的值 <= i - window
                queue.pollFirst();
            }
            if(i >= window -1){  //有效窗口形成
                res[index ++] = array[queue.peekFirst()];
            }
        }
        return res;
    }
}
