package Stack;

import Array.Array;

import java.util.Deque;
import java.util.Stack;

public class MaxMatrix_84 {

    //暴力求解方法,求出以每个节点为高度的最大的矩形的面积，选出最大的即为所求
    public int maxMatrix(int[] heights){
        int maxmatrix = 0;
        int n = heights.length;
        for (int i=0;i<n;i++){
            int w = 1;
            int j=i;
            int high = heights[i];
            while(--j>=0&&heights[j]>=high){
                w++;
            }
            j=i;
            while(++j<n&&heights[j]>=high){
                w++;
            }
            maxmatrix = Math.max(maxmatrix,w*high);
        }
        return maxmatrix;
    }
//    public int returnLeftIndex(int[] heights,int index){
//        int indexReturn = 0;
//        while(index!=0){
//            if (heights[index]>heights[--index]){
//                indexReturn = --index;
//                break;
//            }
//
//            index--;
//        }
//        return indexReturn;
//    }
//    public int returnRightIndex(int[] heights,int index){
//        int indexReturn = heights.length-1;
//        while(index!=heights.length-1){
//            if (heights[index])
//        }
//    }

    /**
     *
     * @param heights
     * @return
     *
     *
     * 方法二：单调栈求解，维护一个单调递增栈，当栈为空或者新遍历的数据大于栈顶元素则入栈
     *
     *
     */
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int[] newHeigths = new int[length+2];

        System.arraycopy(heights,0,newHeigths,1,length);

        int maxMarix = 0;

        Stack<Integer> stack = new Stack<>();


        for (int i=0;i<newHeigths.length;i++){

            while(!stack.isEmpty()&&newHeigths[i]<newHeigths[stack.peek()]){
                int h = newHeigths[stack.pop()];
                maxMarix = Math.max(maxMarix,(i-stack.peek()-1)*h);
            }
            stack.push(i);
        }
        return maxMarix;
    }
}