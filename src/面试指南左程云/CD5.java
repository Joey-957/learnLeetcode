package src.面试指南左程云;
import java.util.*;
public class CD5 {
    public static void main(String[] args) {
        Scanner dc =new Scanner(System.in);
        String str1 = dc.next();
        String str2 = dc.nextLine();
        String str3 = dc.next();
        String str4 = dc.nextLine();
        String str5 = dc.next();
        Deque q = new LinkedList();

    }
    /**
     * 递归遍历数组
     */
    static int[] nums = new int[]{7,1,0,6,9,5,3,5,4};
    static int max = Integer.MIN_VALUE;
    static int length = 0;
    public static void main2(String[] args) {

        length = nums.length;
        recur(0);
        System.out.println(max);

    }
    public static int recur(int index){
        if (index >= length){
            return Integer.MIN_VALUE;
        }
        max = nums[index];
        max = Math.max(max,recur(index+1));
        return max;
    }
}


class Main{
    private Stack<Integer> stack = null;
    private Stack<Integer> stackMin = null;
    static Main instance = null;
    public Main(){
        this.stack = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public static void main(String[] argus){
        instance = new Main();
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        while(i>0){
            i--;
            String str1 = sc.next();

            if(str1.equals("push")){
                int val = sc.nextInt();
                instance.push(val);
            }else if(str1.equals("pop")){
                instance.pop();
            }else if(str1.equals("getMin")){
                instance.getMin();
            }

        }
    }

    public void push(int val){
        this.stack.push(val);
        if(stackMin.isEmpty()||stackMin.peek()>=val){
            stackMin.push(val);
        }
    }

    public int pop(){
        if(this.stack.isEmpty()){
            return -1;
        }else{
            //System.out.println(
            int temp = stack.pop();
            if(temp == stackMin.peek()){
                stackMin.pop();
            }
        }
        return 0;
    }

    public int getMin(){
        if(this.stackMin.isEmpty()){
            return -1;
        }else{
            System.out.println(stackMin.peek());
        }
        return 0;
    }
}

class Main5{
    Stack<Integer> stack ;

    public Main5(){
        this.stack = new Stack<>();
    }

    public static void main(String[] argus){
        Scanner sc = new Scanner(System.in);
        Main5 instance = new Main5();
        while(sc.hasNext()){
            int fre = sc.nextInt();
            if(fre<=0){continue;}

            while(fre>0){
                fre--;
                instance.stack.push(sc.nextInt());
            }
            instance.reverse();
             //int top = instance.stack.pop();
            while(!instance.stack.isEmpty()){
                int top = instance.stack.peek();
                System.out.print(instance.stack.pop() + " ");
            }
            System.out.println();
            //instance.sout(instance.stack);
        }
    }

    public void reverse(){
        if(this.stack.isEmpty()){
            return;
        }
        int last = getAndremovelast();
        reverse();
        this.stack.push(last);

    }

    public int getAndremovelast(){
        int result = this.stack.pop();

        if(this.stack.isEmpty()){

            return result;
        }else{
            int last = getAndremovelast();
            stack.push(result);
            return last;
        }

    }

    public void sout(Stack<Integer> stack){
        while(!this.stack.isEmpty()){
            int top = stack.peek();
            System.out.print(this.stack.pop() + " ");
        }
        System.out.println();
    }

}
