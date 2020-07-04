package Stack;

import java.util.Stack;

/**
 *  使用单调递减栈
 */
public class jieyvshui_42 {

    public int trap(int[] height) {
        int sum_water = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i =0;i<height.length;i++){   //index
            //if (i=height[i])
            while(!stack.isEmpty()&&height[stack.peek()]<height[i]){
//                stack.pop();
//                stack.push(i);
                //while()

            }
            stack.push(i);

        }
        return sum_water;
    }
}
