package Recursion;

import Tree_new.TreeNode;

public class Tree_654 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,6,0,5};
        new Tree_654().constructMaximumBinaryTree(nums);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int index = maxIndex(nums);
        if (index == -1){
            return null;
        }
        TreeNode root = new TreeNode(nums[maxIndex(nums)]);

        root.left = constructMaximumBinaryTree(leftArray(nums,index));
        root.right = constructMaximumBinaryTree(rightArray(nums,index));
        return root;
    }

    public int maxIndex(int[] nums){
        if (nums.length==0){
            return -1;
        }
        int max = nums[0];
        int index = 0;
        for (int i=0;i<nums.length;i++){
            if (max<nums[i]){
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    public int[] leftArray(int[] array,int index){
        //int length = array.length;
        int[] arrayTemp = new int[index];
        for (int i=0;i<index;i++){
            arrayTemp[i] = array[i];
        }
        return arrayTemp;
    }

    public int[] rightArray(int[]array,int index ){
        int length = array.length;
        int[] arrayTemp = new int[length-1-index];
        for (int i=0;i<arrayTemp.length;i++){
            arrayTemp[i] = array[index+i+1];
        }
        return arrayTemp;
    }

}
