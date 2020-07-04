package src.SwordOffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *  方法一：借助辅助站维护一个最大值为数据栈的一个入栈元素的递减栈！！！！！即维护一个递减栈即可
 */
public class Swold30 {
    public Stack<Integer> stackDate =null;
    public Stack<Integer> stackTemp = null;
    /** initialize your data structure here. */
//    public MinStack() {
//        stackDate = new Stack<Integer>();
//        stackTemp = new Stack<Integer>();
//    }
    public void push(int x) {
        stackDate.push(x);
        if(stackTemp.isEmpty()){
            stackTemp.push(x);
        }else{
            if(stackTemp.peek()>=x){
                stackTemp.push(x);
            }
        }
    }

    public void pop() {
        int temp = 0;
        if(!stackDate.isEmpty()){
            temp=stackDate.pop();
        }
        if(temp==stackTemp.peek()){
            stackTemp.pop();
        }
    }

    public int top() {

        return stackDate.peek();

    }

    public int min() {
        return stackTemp.peek();
    }


}
