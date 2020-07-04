package SwordOffer;

import java.util.LinkedList;
import java.util.Stack;

public class Sword09 {
    public static void main(String[] args) {
        LinkedList stack = new LinkedList();
        //Stack stack1 = new LinkedList<Object>();
        /**
         *  1、LinkedList 并没有实现stack接口，所以不能向上引用
         *  2、使用Stack 创建栈效率低底层是数组，建议使用LinkedList 双向链表创建维护stack
         *  3、LinkedList 可以实现队列和栈的功能
         *      stack： 添加元素： push（） 删除元素： pop（）
         *      queue： 添加元素： offer（）、删除元素：poll（）
         *
         */

//        LinkedList<Integer> stack1 = null;
//        LinkedList<Integer> stack2 = null;
//    public CQueue() {
//            stack1 = new LinkedList<>();
//            stack2 = new LinkedList<>();
//
//        }
//
//        public void appendTail(int value) {
//            stack1.offer(value);
//        }
//
//        public int deleteHead() {
//            if(stack2.isEmpty()){
//                if(stack1.isEmpty()){
//                    return -1;
//                }
//                while(!stack1.isEmpty()){
//                    stack2.offer(stack1.poll());
//                }
//                return stack2.poll();
//            }else{
//                return stack2.poll();
//            }




        }

}
