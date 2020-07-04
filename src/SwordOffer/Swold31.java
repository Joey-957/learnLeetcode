package src.SwordOffer;

import java.util.Stack;

/**
 *  栈的压入弹出序列
 *  做法：借助一个辅助栈，遍历压入数组，把数据压入栈中，while判断当弹出数组==栈顶元素时弹出栈（然后弹出数组下表加一继续判断），
 *  当遍历完压入栈数组，栈不为空 即弹出序列不正确
 */
public class Swold31 {


    // 优质解法
    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }



    
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int lengthPush = pushed.length;
        int lengthPop = popped.length;
        if(lengthPush!=lengthPop){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for(int i=0;i<lengthPush;i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty()&&popped[index]==stack.peek()){
                stack.pop();
                index++;

            }
        }
        return stack.isEmpty();
    }



}
